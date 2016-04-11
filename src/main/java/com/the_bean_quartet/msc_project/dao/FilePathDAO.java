package com.the_bean_quartet.msc_project.dao;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.FilePath;

@Local
public interface FilePathDAO {
	public FilePath getFilePath(String name);
	public void addFilePath(FilePath path);
	public void updateFilePath(int filePathId, String newPath);
}
