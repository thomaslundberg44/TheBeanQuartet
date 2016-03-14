package com.the_bean_quartet.msc_project.dao.jpa;


import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.the_bean_quartet.msc_project.dao.BaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;


@Stateless
@Local
public class JPABaseDataDAO implements BaseDataDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void addData(BaseData disc) {
		Query query = em.createQuery("from BaseData");
		List<BaseData> data = query.getResultList(); 
		if (!data.contains(disc))
			em.persist(disc);	
	}

	public void addCollectionData(Collection<BaseData> data) {
		Query query = em.createQuery("from BaseData");
		List<BaseData> dataList = query.getResultList();
		for(BaseData dataItem : data) {
			if(!dataList.contains(dataItem))
				em.persist(dataItem);
		}
	}
	
//	public CompactDisc getCompactDiscByTitle(String title) {
//		// TODO Auto-generated method stub		
//		Query query  = em.createQuery("from CompactDisc cd where cd.title = :title");
//		query.setParameter("title", title);
//		// remember we are assuming only one album has any particular title
//		// could have used getSingleResult() but this an exception if there is more than one result
//		List<CompactDisc> result = query.getResultList();
//		return result.get(0);
//	}
//	
//	
//	public Collection<CompactDisc> getDiscsByArtist(String artist) {
//		// TODO Auto-generated method stu
//		Query query  = em.createQuery("from CompactDisc cd where cd.artist = :artist");
//		query.setParameter("artist", artist);
//		List<CompactDisc> result = query.getResultList();
//		return result;
//	}

	public Collection<BaseData> getAllData() {
		Query query = em.createQuery("from BaseData");
		List<BaseData> bData = query.getResultList(); 
		return bData;
	}
	public Collection<BaseData> getAllModelData() {	
		Query query = em.createQuery("select DISTINCT(c.ueTable.marketingName) from BaseData c");
		List<BaseData> marketingNameData = query.getResultList(); 
		return marketingNameData;
	}
//	public Collection<BaseData> getAllModelSearchData(String model) {
//		Query query = em.createQuery("select bd.ueTable.tac from BaseData bd where bd.ueTable.marketingName =:uetypes");
//		query.setParameter("uetypes", model);
//		int UEData = (Integer) query.getResultList().get(0);
//	
//		Query query1 = em.createQuery("select count(bd.failureClass) from BaseData bd where bd.ueTable.tac =:hello");
//		query1.setParameter("hello", UEData);
//
//		List<BaseData> UEData1 = query1.getResultList(); 
//		return UEData1;
//	}
	public Collection<BaseData> getAllModelSearchData(String model, String startTime, String finishTime) {
		Query query = em.createQuery("select bd.ueTable.tac from BaseData bd where bd.ueTable.marketingName =:uetypes");
		query.setParameter("uetypes", model);
		int UEData = (Integer) query.getResultList().get(0);
		System.out.println("Parameters retrieved: start = "+startTime+", finish = "+finishTime );
		Query query1 = em.createQuery("select count(bd.failureClass) from BaseData bd where bd.ueTable.tac =:hello "
				+ "and bd.date >=:dateStart and bd.date <:dateEnd ");
		query1.setParameter("hello", UEData);
		query1.setParameter("dateStart", startTime);
		query1.setParameter("dateEnd", finishTime);
		
		List<BaseData> UEData1 = query1.getResultList(); 
		return UEData1;
	}
}
