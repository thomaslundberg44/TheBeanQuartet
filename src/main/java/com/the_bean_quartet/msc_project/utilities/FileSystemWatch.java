package com.the_bean_quartet.msc_project.utilities;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.services.BaseDataService;
import com.the_bean_quartet.msc_project.services.ErrorDataService;
import com.the_bean_quartet.msc_project.services.EventCauseService;
import com.the_bean_quartet.msc_project.services.FailureDataService;
import com.the_bean_quartet.msc_project.services.MccDataService;
import com.the_bean_quartet.msc_project.services.UETypeService;

@Stateless
public class FileSystemWatch {

	private static final String FOLDER_PATH = "/home/tommy/Documents/testWatchFolder/";

	@Inject	private BaseDataService dataService;
	@Inject	private ErrorDataService errorService;
	@Inject	private FailureDataService failureService;
	@Inject	private EventCauseService eventService;
	@Inject	private UETypeService ueService;
	@Inject	private MccDataService mccService;

	@Asynchronous
	public void fileSystemWatch() {
		try {
			final WatchService watcher = FileSystems.getDefault().newWatchService();
			Path dir = Paths.get(FOLDER_PATH);
			dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

			allowWatchServiceShutdown(watcher);

			System.out.println("Watch Service registered for dir: " + dir.getFileName());

			while (true) {
				WatchKey key;
				try {
					key = watcher.take();
				} catch (InterruptedException ex) {
					return;
				}

				for (WatchEvent<?> event : key.pollEvents())
					handleWatchEvent(event);

				boolean valid = key.reset();
				if (!valid)
					break;
			}

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	private void handleWatchEvent(WatchEvent<?> event) {
		WatchEvent.Kind<?> kind = event.kind();

		@SuppressWarnings("unchecked")
		WatchEvent<Path> ev = (WatchEvent<Path>) event;
		Path fileName = ev.context();

		System.out.println(kind.name() + ": " + fileName);

		if (kind == ENTRY_MODIFY && fileName.toString().endsWith(".xls")) {
			System.out.println("My source file has changed!!!");
			ProcessXLSFile processFile = new ProcessXLSFile(dataService, errorService, failureService,
					eventService, mccService, ueService);
			processFile.processXLSSpreadsheet(new File(FOLDER_PATH + fileName.toFile()));
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
