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
	//private Long imsi=new Long("344930000000011");
	//private String imsiVal;
	
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
			//Query query = em.createQuery("select DISTINCT(c.date) from BaseData c");
			List<BaseData> bimsiData = query.getResultList(); 
			return bimsiData;
	}
	
	
	//getting individual date and time out of base data table
		public Collection<BaseData> getDateData() {
			Query query = em.createQuery("select DISTINCT(c.date) from BaseData c");
			List<BaseData> bimsiData = query.getResultList(); 
			return bimsiData;
		}	
	
	//user story 4...................................//
	public Collection<BaseData> getAllIMSIRelatedData(String imsi) {
		Query query  = em.createQuery("select bd.eventCause.eventId,bd.eventCause.causeCode,bd.eventCause.description,bd.failureClass.failureClass,bd.failureClass.description "
				+ "from BaseData bd "
				+ "where bd.imsi = :imsi");
			query.setParameter("imsi", imsi);
			List<BaseData> allImsiData = query.getResultList(); 
			return allImsiData;
	}
	
	//user story 7....................//
	public Collection<BaseData> getImsiList(String date1,String date2) {
		Query query = em.createQuery(""
		+"select bd.id, bd.imsi, bd.failureClass.description,bd.failureClass.failureClass"
		+"from BaseData bd "
		+"where bd.date >=:date1 and bd.date <:date2 "
		+"group by bd.imsi");
		query.setParameter("date1", date1);
		query.setParameter("date2", date2);
		List<BaseData> alldatebase = query.getResultList();
		return alldatebase;
	}

	
	
	
	

}
