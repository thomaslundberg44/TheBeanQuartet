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
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/watchservice")
@Stateless
public class FileSystemWatch {

	private static final String FOLDER_PATH = "/home/tommy/Documents/testWatchFolder/";

	@Inject
	private ProcessXLSFile fileService;

	@GET
	@Asynchronous
	@Path("/start")
	public void fileSystemWatch() {
		java.nio.file.Path watchDir = new File(FOLDER_PATH).toPath();
		FileSystem fileSystem = watchDir.getFileSystem();
		try (WatchService watcher = fileSystem.newWatchService()) {
			watchDir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
			allowWatchServiceShutdown(watcher);

			watchLoop(watcher);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClosedWatchServiceException e) {
			e.printStackTrace();
		}
	}

	private void watchLoop(WatchService watcher) {
		WatchKey key = null;
		while (true) {
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
			fileService.processXLSSpreadsheet(new File(FOLDER_PATH + fileName.toFile()));
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
