package com.the_bean_quartet.msc_project.services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.the_bean_quartet.msc_project.utilities.FileSystemWatch;

@Singleton
@Startup
public class AutoImportService {
	
	@EJB
	private FileSystemWatch fileSysWatch;

	public void setFileSystemWatch(FileSystemWatch fileSysWatch) {
		this.fileSysWatch = fileSysWatch;
	}

	@PostConstruct
	public void startFileSystemWatch() {
		fileSysWatch.fileSystemWatch();
	}
}
