package com.the_bean_quartet.msc_project.services;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.FilePathDAO;
import com.the_bean_quartet.msc_project.entities.FilePath;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class FilePathServiceEJB implements FilePathService {
	
	@Inject
	private FilePathDAO dao;

	@Override
	public FilePath getFilePath(String name) {
		return dao.getFilePath(name);
	}

	@Override
	public void addFilePath(FilePath filePath) {
		dao.addFilePath(filePath);
	}

	@Override
	public void updateFilePath(int filePathId, String newPath) {
		dao.updateFilePath(filePathId, newPath);
	}

}
