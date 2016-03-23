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
	
	public void deleteAllEntries() {
		Query query = em.createQuery("DELETE from BaseData");
		query.executeUpdate();
	}
	
	public void clearAllEntries() {
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
	
	//getting individual imsi out of base data table
	public Collection<BaseData> getAllIMSIData() {	
			Query query = em.createQuery("select DISTINCT(bd.imsi) from BaseData bd");
			List<BaseData> bimsiData = query.getResultList(); 
			return bimsiData;
	}
	
	//user story 4...................................//
	public Collection<BaseData> getAllIMSIRelatedData(String imsi) {
		Long longImsi=Long.valueOf(imsi);
		System.out.println("111111111111111111111111111   "+longImsi);

		Query query  = em.createQuery("select bd.eventCause.id.eventId, bd.eventCause.id.causeCode, bd.eventCause.description,"
				+ "bd.failureClass.failureClass, bd.failureClass.description "
				+ "from BaseData bd "
				+ "where bd.imsi =:imsi");
			
			System.out.println("222222222222222222"+longImsi);
			query.setParameter("imsi", longImsi);
			List<BaseData> allImsiData = query.getResultList(); 
			return allImsiData;
	}
	
	public Collection<BaseData> getEachImsiSearchData(String startTime, String finishTime){
		Query query = em.createQuery("select DISTINCT (bd.imsi),count(bd.failureClass), sum(bd.duration) from BaseData bd "
				+ "where bd.date >=:dateStart and bd.date <:dateEnd group by bd.imsi");
		query.setParameter("dateStart", startTime);
		query.setParameter("dateEnd", finishTime);
		List<BaseData> UEData1 = query.getResultList(); 
		return UEData1;
	}
	
	public Collection<BaseData> getListImsiWithFailureTimeRange(String startTime, String finishTime){

		Query query = em.createQuery("select DISTINCT(bd.imsi), bd.failureClass from BaseData bd "
				+ "where bd.date >=:dateStart and bd.date <:dateEnd group by bd.imsi");
		query.setParameter("dateStart", startTime);
		query.setParameter("dateEnd", finishTime);
		List<BaseData> ListImsiWithFailureTimeRange = query.getResultList();
		return ListImsiWithFailureTimeRange;
	
	}

	public Collection<BaseData> getTop10ImsiSearchData(String startTime, String finishTime) {
		Query query = em.createQuery("select DISTINCT (bd.imsi),count(bd.failureClass) from BaseData bd "
				+ "where bd.date >=:dateStart and bd.date <:dateEnd group by bd.imsi order by bd.failureClass");
		query.setParameter("dateStart", startTime);
		query.setParameter("dateEnd", finishTime);
		query.setMaxResults(3);
		List<BaseData> UEData1 = query.getResultList();
		//System.out.println(UEData1.get(1).getFailureClass());
		return UEData1;
	}

	public Collection<BaseData> getImsiFailureCount(String imsiValue,String startTime, String finishTime) {
		Long longImsi=Long.valueOf(imsiValue);
		System.out.println("111111111111111111111111111   "+longImsi);
		Query query = em.createQuery("select bd.imsi, count(bd.failureClass) from BaseData bd "
				+ "where bd.date >=:dateStart and bd.date <:dateEnd and bd.imsi=:imsi");
		query.setParameter("dateStart", startTime);
		query.setParameter("dateEnd", finishTime);
		query.setParameter("imsi", longImsi);
		List<BaseData> UEData1 = query.getResultList(); 
		return UEData1;
	}
	
	

	
	
}
