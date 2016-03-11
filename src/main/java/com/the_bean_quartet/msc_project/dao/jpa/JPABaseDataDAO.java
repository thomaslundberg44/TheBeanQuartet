package com.the_bean_quartet.msc_project.dao.jpa;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.the_bean_quartet.msc_project.dao.BaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.FailureClass;


@Stateless
@Local
public class JPABaseDataDAO implements BaseDataDAO {

	@PersistenceContext
	private EntityManager em;
	private Long imsi=new Long("344930000000011");
	
	public void addData(BaseData disc) {
	
		Query query = em.createQuery("from BaseData");
		List<BaseData> data = query.getResultList(); 
		if (!data.contains(disc))
			em.persist(disc);	
	}


	public Collection<BaseData> getAllData() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from BaseData");
		List<BaseData> bData = query.getResultList(); 
		return bData;
		
	}
	//getting individual imsi out of base data table
	public Collection<BaseData> getAllIMSIData() {	
			Query query = em.createQuery("select DISTINCT(c.imsi) from BaseData c");
			List<BaseData> bimsiData = query.getResultList(); 
			return bimsiData;
	}
	
	//getting data out of base data on basis of value of imsi
//	public Collection<BaseData> getAllIMSIRelatedData() {
//		Query query  = em.createQuery("select bd.eventCause.eventId,bd.eventCause.causeCode,bd.eventCause.description,bd.failureClass.failureClass,bd.failureClass.description "
//						+ "from BaseData bd "
//						+ "where bd.imsi = :imsi");
//		query.setParameter("imsi", imsi);
//		List<BaseData> allImsiData = query.getResultList(); 
//		return allImsiData;
//	}


	public Collection<BaseData> getAllIMSIRelatedData(String imsiVal) {
		Query query  = em.createQuery("select bd.eventCause.eventId,bd.eventCause.causeCode,bd.eventCause.description,bd.failureClass.failureClass,bd.failureClass.description "
				+ "from BaseData bd "
				+ "where bd.imsi = :imsi");
			query.setParameter("imsi", imsi);
			List<BaseData> allImsiData = query.getResultList(); 
			return allImsiData;
	}
	
	
	
	

}
