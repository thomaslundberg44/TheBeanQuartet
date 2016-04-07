package com.the_bean_quartet.msc_project.dao.jpa;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.the_bean_quartet.msc_project.dao.FilePathDAO;
import com.the_bean_quartet.msc_project.entities.FilePath;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JPAFilePathDAO implements FilePathDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public FilePath getFilePath(String name) {
		Query query = em.createQuery("From FilePath fp where fp.name=:name");
		query.setParameter("name", name);
		FilePath path = (FilePath) query.getSingleResult();
		return path;
	}

	@Override
	public void addFilePath(FilePath path) {
		Query query = em.createQuery("From FilePath");
		@SuppressWarnings("unchecked")
		List<FilePath> paths = query.getResultList();
		if(!paths.contains(paths))
			em.persist(path);
	}

	@Override
	public void updateFilePath(int filePathId, String newPath) {
		FilePath filePath = em.find(FilePath.class, filePathId);
		filePath.setPath(newPath);
		em.merge(filePath);
	}

}
