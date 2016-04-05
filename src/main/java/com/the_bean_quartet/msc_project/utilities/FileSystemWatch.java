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

@Path("/watchservice")
@Stateless
public class FileSystemWatch {

	private String folder_path = "/home/tommy/Documents/testWatchFolder/";

	@Inject
	private ProcessXLSFile fileService;
	
	private static WatchService watcher;
	private boolean watchLoopActive = false;
	
	public FileSystemWatch() {}
	
	/**
	 * Start watch service in specified folder
	 */
	@Asynchronous
	public void fileSystemWatch() {
		java.nio.file.Path watchDir = new File(folder_path).toPath();
		FileSystem fileSystem = watchDir.getFileSystem();
		try {
			System.out.println("In file watch starter: starting watch service");
			watcher = fileSystem.newWatchService();
			watchDir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
			
			allowWatchServiceShutdown(watcher);

			watchLoop(watcher);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClosedWatchServiceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Set new directory path for watch service
	 * If watcher has already been started, stop and restart in new path
	 * 
	 * @param The new path for directory to be watched
	 */
	@POST
	@Path("/setpath")
	@Consumes("text/plain")
	public void setWatchDirPath(String path) {
		System.out.println("Request for new watch service path: "+path);
		this.folder_path = path;
		if(watcher != null) {
			try {
				watchLoopActive = false;
				watcher.close();
				watcher = null;
			} catch (IOException e) {
				System.out.println("Failed to shut down watcher");
			}
			fileSystemWatch();
		}
	}
	
	/**
	 * Get the watch service directory path
	 * @param watcher
	 */
	@GET
	@Path("/getpath")
	@Produces("text/plain")
	public String getWatchDirPath() {
		return folder_path;
	}

	private void watchLoop(WatchService watcher) {
		WatchKey key = null;
		watchLoopActive = true;
		while (watchLoopActive) {
			try {
				key = watcher.take();
				for (WatchEvent<?> watchEvent : key.pollEvents())
					handleWatchEvent(watchEvent);

			} catch (InterruptedException e) {
				System.out.println("Watcher key interrupted: " + e.getMessage());
			}
			if (!key.reset())
				break;
		}
	}

	private void handleWatchEvent(WatchEvent<?> event) {
		WatchEvent.Kind<?> kind = event.kind();

		@SuppressWarnings("unchecked")
		WatchEvent<java.nio.file.Path> ev = (WatchEvent<java.nio.file.Path>) event;
		java.nio.file.Path fileName = ev.context();

		System.out.println(kind.name() + ": " + fileName);

		if (kind == ENTRY_MODIFY && fileName.toString().endsWith(".xls")) {
			System.out.println("Source file being watched has changed!");
			fileService.processXLSSpreadsheet(new File(folder_path + fileName.toFile()));
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
