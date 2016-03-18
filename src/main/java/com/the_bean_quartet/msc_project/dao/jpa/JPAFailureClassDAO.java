package com.the_bean_quartet.msc_project.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.the_bean_quartet.msc_project.dao.FailureClassDAO;
import com.the_bean_quartet.msc_project.entities.FailureClass;

@Stateless
@Local
public class JPAFailureClassDAO implements FailureClassDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void addFailures(FailureClass failures) {
		Query query = em.createQuery("from FailureClass");
		List<FailureClass> failureClasses = query.getResultList(); 
		if (!failureClasses.contains(failures))
			em.persist(failures);
	}

	public Collection<FailureClass> getAllFailures() {
		Query query = em.createQuery("from FailureClass");
		List<FailureClass> failureClasses = query.getResultList(); 
		return failureClasses;
	}
	
	public void deleteAllEntries() {
		Query query = em.createQuery("DELETE from FailureClass");
		query.executeUpdate();
	}
	
	public Collection<FailureClass> getFailuresBaseData() {
		Query query = em.createQuery("from FailureClass LEFT JOIN BaseData");
		List<FailureClass> failures = query.getResultList();
		return failures;
	}

	public void addListFailures(Collection<FailureClass> failureClassList) {
		Query query = em.createQuery("from FailureClass");
		List<FailureClass> failureClasses = query.getResultList(); 
		for(FailureClass failureClass : failureClassList) {
			if (!failureClasses.contains(failureClass))
				em.merge(failureClass);
		}
	}
}
