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
	
	public Collection<FailureClass> getFailuresBaseData() {
		Query query = em.createQuery("from FailureClass LEFT JOIN BaseData");
		List<FailureClass> failures = query.getResultList();
		return failures;
	}
	
	public Collection<FailureClass> getallFailuresBaseData(int value) {
		Query query = em.createQuery("select description from FailureClass cd where cd.failureClass = :value");
		List<FailureClass> failures1 = query.getResultList();
		return failures1;
	}

}
