package com.the_bean_quartet.msc_project.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.the_bean_quartet.msc_project.dao.UETypeClassDAO;
import com.the_bean_quartet.msc_project.entities.UETypeClass;


@Stateless
@Local
public class JPAUETypeClassDAO implements UETypeClassDAO {

	@PersistenceContext
	private EntityManager em;


	public void addUE(UETypeClass UEType) {
		Query query = em.createQuery("from UETypeClass");
		List<UETypeClass> ueList = query.getResultList(); 
		if (!ueList.contains(UEType))
			em.persist(UEType);
	}
	
	public void deleteAllEntries() {
		Query query = em.createQuery("DELETE from UETypeClass");
		query.executeUpdate();
	}

	public Collection<UETypeClass> getAllUEType() {
		Query query = em.createQuery("from UETypeClass");
		List<UETypeClass> UEType = query.getResultList(); 
		return UEType;
	}

	@TransactionAttribute (TransactionAttributeType.REQUIRES_NEW)
	public void addListUE(Collection<UETypeClass> ueList) {
		Query query = em.createQuery("from UETypeClass");
		List<UETypeClass> ueDBList = query.getResultList(); 
		for(UETypeClass ueClass : ueList) {
			if (!ueDBList.contains(ueClass))
				em.merge(ueClass);
		}
	}
}
