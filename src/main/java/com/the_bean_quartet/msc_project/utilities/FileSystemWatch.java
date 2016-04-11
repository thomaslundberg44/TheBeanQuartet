package com.the_bean_quartet.msc_project.utilities;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.File;
import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.FileSystem;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.the_bean_quartet.msc_project.entities.FilePath;
import com.the_bean_quartet.msc_project.services.FilePathService;

@Path("/watchservice")
@Stateless
public class FileSystemWatch {

	@Inject private ProcessXLSFile fileService;
	@Inject private FilePathService filePathService;

	private static WatchService watcher;
	private static boolean watchLoopActive = false;

	private static Thread watchThread;

	public FileSystemWatch() {}

	/**
	 * Start watch service in specified folder
	 */
	@Asynchronous
	public void fileSystemWatch() {
		watchThread = new Thread(new Runnable() {
			public void run() {
				String folderPath = getDirectoryPath();
				java.nio.file.Path watchDir = new File(folderPath).toPath();
				FileSystem fileSystem = watchDir.getFileSystem();
				try {
					System.out.println("FileSystemWatch - "+"starting "
							+ "watch service for directory: "+folderPath);
					watcher = fileSystem.newWatchService();
					watchDir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

					allowWatchServiceShutdown(watcher);

					watchLoop(watcher, folderPath);

				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClosedWatchServiceException e) {
					e.printStackTrace();
				}
			}
		});
		watchThread.start();
	}

	/**
	 * Set new directory path for watch service If watcher has already been
	 * started, stop and restart in new path
	 * 
	 * @param The new path for directory to be watched
	 */
	@POST
	@Path("/setpath")
	@Consumes("text/plain")
	public void setWatchDirPath(String path) {
		if(!(path.endsWith("/") || path.endsWith("\\")))
			path += "/";
		System.out.println("Request for new watch service path: " + path);
		writeNewFilePath(path);
		watchLoopActive = false;
		watchThread.interrupt();
		fileSystemWatch();
	}
	
	private void writeNewFilePath(String path) {
		FilePath filePath = filePathService.getFilePath("auto_import_folder");
		filePathService.updateFilePath(filePath.getId(), path);
		System.out.println("Attempting to write new file path: "+path);
	}
	
	/**
	 * Get the watch service directory path
	 * 
	 * @param watcher
	 */
	@GET
	@Path("/getpath")
	@Produces("text/plain")
	public String getWatchDirPath() {
		return getDirectoryPath();
	}
	
	private String getDirectoryPath() {
		String filePath = filePathService.getFilePath("auto_import_folder").getPath();
		System.out.println("Got file path for folder watcher: "+filePath);
		return filePath;
	}

	private void watchLoop(WatchService watcher, String folderPath) {
		WatchKey key = null;
		watchLoopActive = true;
		while (watchLoopActive) {
			try {
				key = watcher.take();
				for (WatchEvent<?> watchEvent : key.pollEvents())
					handleWatchEvent(watchEvent, folderPath);

			} catch (InterruptedException e) {
				System.out.println("Watcher key interrupted: " + e.getMessage());
			}
			if(!(key == null) && !key.reset() )
				break;
		}
	}

	private void handleWatchEvent(WatchEvent<?> event, String folderPath) {
		WatchEvent.Kind<?> kind = event.kind();

		@SuppressWarnings("unchecked")
		WatchEvent<java.nio.file.Path> ev = (WatchEvent<java.nio.file.Path>) event;
		java.nio.file.Path fileName = ev.context();

		System.out.println(kind.name() + ": " + fileName);

		if (kind == ENTRY_MODIFY && fileName.toString().endsWith(".xls")) {
			System.out.println("Source file being watched has changed!");
			fileService.processXLSSpreadsheet(new File(folderPath + fileName.toFile()));
		}
	}

	private void allowWatchServiceShutdown(final WatchService watcher) {
		Runtime.getRuntime().addShutdownHook(new Thread("Shutdown watch service") {
			public void run() {
				try {
					watcher.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
