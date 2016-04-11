package com.the_bean_quartet.msc_project.services;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.FilePath;

@Local
public interface FilePathService {
	public FilePath getFilePath(String name);
	public void addFilePath(FilePath filePath);
	public void updateFilePath(int filePathId, String newPath);
}
