//package com.the_bean_quartet.msc_project.services;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.ejb.Singleton;
//import javax.ejb.Startup;
//import javax.ejb.TransactionAttribute;
//import javax.ejb.TransactionAttributeType;
//
//import com.the_bean_quartet.msc_project.utilities.FileSystemWatch;
//
//@Singleton
//@Startup
//public class AutoImportService {
//	
//	@EJB
//	private FileSystemWatch fileSysWatch;
//
//	public void setFileSystemWatch(FileSystemWatch fileSysWatch) {
//		this.fileSysWatch = fileSysWatch;
//	}
//
//	@PostConstruct
//	@TransactionAttribute (TransactionAttributeType.REQUIRES_NEW)
//	public void startFileSystemWatch() {
//		fileSysWatch.fileSystemWatch();
//	}
//}
