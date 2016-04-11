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

import com.the_bean_quartet.msc_project.dao.MccMncDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.MccData;

@Stateless
@Local
public class JPAMccDataDAO implements MccMncDataDAO{

	@PersistenceContext
	private EntityManager em;

	public void addData(MccData mccData) {
		
		Query query = em.createQuery("from MccData");
		List<MccData> data = query.getResultList(); 
		if (!data.contains(mccData))
			em.persist(mccData);	
	}
	
	public void deleteAllEntries() {
		Query query = em.createQuery("DELETE from MccData");
		query.executeUpdate();
	}

	public Collection<MccData> getAllMccData() {
		
		Query query = em.createQuery("from MccData");
		List<MccData> mccData = query.getResultList(); 
		return mccData;
		
	}

	@TransactionAttribute (TransactionAttributeType.REQUIRES_NEW)
	public void addListData(Collection<MccData> dataList) {
		Query query = em.createQuery("from MccData");
		List<MccData> data = query.getResultList();
		for(MccData mccData : dataList) {
			if (!data.contains(mccData))
				em.merge(mccData);
		}
	}
}
