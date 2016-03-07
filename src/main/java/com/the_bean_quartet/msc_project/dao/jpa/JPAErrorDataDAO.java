package com.the_bean_quartet.msc_project.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.the_bean_quartet.msc_project.dao.ErrorDataDAO;
import com.the_bean_quartet.msc_project.entities.ErrorData;

@Stateless
@Local
public class JPAErrorDataDAO implements ErrorDataDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void addData(ErrorData eData) {
		Query query = em.createQuery("from ErrorData");
		List<ErrorData> data = query.getResultList(); 
		if (!data.contains(eData))
			em.persist(eData);
	}

	public Collection<ErrorData> getAllData() {
		Query query = em.createQuery("from ErrorData");
		List<ErrorData> eData = query.getResultList(); 
		return eData;
	}

}