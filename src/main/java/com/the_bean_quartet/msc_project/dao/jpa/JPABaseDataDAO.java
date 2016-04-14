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

import com.the_bean_quartet.msc_project.dao.BaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
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

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addCollectionData(Collection<BaseData> data) {
		System.out.println("In Base Data JPA. Adding collection size: " + data.size());
		for (BaseData dataItem : data) {
			em.persist(dataItem);
		}
	}

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

	public Collection<BaseData> getAllModelSearchData(String model, String startTime, String finishTime) {

		Query query = em.createQuery("select bd.ueTable.tac from BaseData bd where bd.ueTable.marketingName =:uetypes");
		query.setParameter("uetypes", model);
		int UEData = (Integer) query.getResultList().get(0);
		System.out.println("Parameters retrieved: start = " + startTime + ", finish = " + finishTime);
		Query query1 = em.createQuery("select count(bd.failureClass) from BaseData bd where bd.ueTable.tac =:hello "
				+ "and bd.date >=:dateStart and bd.date <:dateEnd ");
		query1.setParameter("hello", UEData);
		query1.setParameter("dateStart", startTime);
		query1.setParameter("dateEnd", finishTime);

		List<BaseData> UEData1 = query1.getResultList();
		return UEData1;
	}

	// getting individual imsi out of base data table
	public Collection<BaseData> getAllIMSIData() {
		Query query = em.createQuery("select DISTINCT(bd.imsi) from BaseData bd");
		List<BaseData> bimsiData = query.getResultList();
		return bimsiData;
	}

	// user story 4...................................//
	public Collection<BaseData> getAllIMSIRelatedData(String imsi) {
		Long longImsi = Long.valueOf(imsi);
		System.out.println("111111111111111111111111111   " + longImsi);

		Query query = em
				.createQuery("select bd.eventCause.id.eventId, bd.eventCause.id.causeCode, bd.eventCause.description,"
						+ "bd.failureClass.failureClass, bd.failureClass.description " + "from BaseData bd "
						+ "where bd.imsi =:imsi");

		System.out.println("222222222222222222" + longImsi);
		query.setParameter("imsi", longImsi);
		List<BaseData> allImsiData = query.getResultList();
		return allImsiData;
	}

	public Collection<BaseData> getEachImsiSearchData(String startTime, String finishTime) {
		Query query = em
				.createQuery("select DISTINCT (bd.imsi),count(bd.failureClass), sum(bd.duration) from BaseData bd "
						+ "where bd.date >=:dateStart and bd.date <:dateEnd group by bd.imsi");
		query.setParameter("dateStart", startTime);
		query.setParameter("dateEnd", finishTime);
		List<BaseData> UEData1 = query.getResultList();
		return UEData1;
	}

	public Collection<BaseData> getListImsiWithFailureTimeRange(String startTime, String finishTime) {
		// long timer = System.currentTimeMillis();

		Query query = em.createQuery("select DISTINCT(bd.imsi), bd.failureClass from BaseData bd "
				+ "where bd.date >=:dateStart and bd.date <:dateEnd group by bd.imsi");
		query.setParameter("dateStart", startTime);
		query.setParameter("dateEnd", finishTime);
		// countTime(timer);
		List<BaseData> ListImsiWithFailureTimeRange = query.getResultList();
		return ListImsiWithFailureTimeRange;

	}

	public void countTime(long startTime) {

		long endTime = System.currentTimeMillis();
		float duration = (endTime - startTime) / 1000.0f;
		System.out.print("111111111Time took: " + duration);
	}

	public Collection<BaseData> getTop10ImsiSearchData(String startTime, String finishTime) {
		Query query = em.createQuery("select (bd.imsi), count(bd.imsi) "
				+ "from BaseData bd "
				+ "where bd.date >=:dateStart "
				+ "and bd.date <=:dateEnd "
				+ "group by bd.imsi "
				+ "order by count(bd.imsi) DESC");
		query.setParameter("dateStart", startTime);
		query.setParameter("dateEnd", finishTime);
		query.setMaxResults(10);
		List<BaseData> UEData1 = query.getResultList();
		
		return UEData1;
	}

	public Collection<BaseData> getImsiFailureCount(String imsiValue, String startTime, String finishTime) {
		Long longImsi = Long.valueOf(imsiValue);
		System.out.println("111111111111111111111111111   " + longImsi);
		Query query = em.createQuery("select bd.imsi, count(bd.failureClass) from BaseData bd "
				+ "where bd.date >=:dateStart and bd.date <:dateEnd and bd.imsi=:imsi");
		query.setParameter("dateStart", startTime);
		query.setParameter("dateEnd", finishTime);
		query.setParameter("imsi", longImsi);
		List<BaseData> UEData1 = query.getResultList();
		return UEData1;
	}

	public Collection<BaseData> getAllModelEventCauseData(String model) {
		Query query = em.createQuery("select bd.ueTable.tac from BaseData bd where bd.ueTable.marketingName =:uetypes");
		query.setParameter("uetypes", model);
		int UEData = (Integer) query.getResultList().get(0);

		Query query1 = em.createQuery(
				"select bd.eventCause.id.eventId, bd.eventCause.id.causeCode, count(bd.id), bd.ueTable.tac, bd.ueTable.manufacturer"
						+ " from BaseData bd where bd.ueTable.tac =:modelVal "
						+ " group by bd.eventCause.id.eventId, bd.eventCause.id.causeCode");

		query1.setParameter("modelVal", UEData);

		List<BaseData> UEData1 = query1.getResultList();
		System.out.println("-------------------------" + UEData1.size());
		return UEData1;
	}

	public Collection<BaseData> getCauseCodeWithCallFailureForAnImsi(String imsi) {
		Long longImsi = Long.valueOf(imsi);
		System.out.println("111111111111111111111111111   " + longImsi);
		Query query = em.createQuery("select DISTINCT(bd.eventCause.id.causeCode), bd.failureClass.failureClass, bd.failureClass.description "
				+ "from BaseData bd " + "where bd.imsi =:imsi");

		System.out.println("222222222222222222" + longImsi);
		query.setParameter("imsi", longImsi);
		List<BaseData> CauseCodeWithCallFailureForAnImsi = query.getResultList();
		return CauseCodeWithCallFailureForAnImsi;
	}

	public Collection<BaseData> getAllFailureCauseClass() {
		Query query = em.createQuery("select DISTINCT(bd.failureClass.failureClass) from BaseData bd");
		List<BaseData> failureCauseClass = query.getResultList();
		return failureCauseClass;
	}

	public Collection<BaseData> getImsiForAnFailureCauseClass(String failureCauseClass) {
		Integer intFailureCauseClass = Integer.valueOf(failureCauseClass);
		System.out.println("111111111111111111111111111   " + intFailureCauseClass);

		Query query = em.createQuery(
				"select DISTINCT (bd.imsi),count(bd.failureClass) from BaseData bd where bd.failureClass.failureClass =:failureCauseClass group by bd.imsi order by bd.failureClass");

		query.setParameter("failureCauseClass", intFailureCauseClass);
		System.out.println("222222222222222222" + intFailureCauseClass);
		List<BaseData> ImsiForAnFailureCauseClass = query.getResultList();
		
		return ImsiForAnFailureCauseClass;
	}

	public Collection<BaseData> getTopTenMarketOperatorCell_ID(String failureCauseClass, String startTime,
			String finishTime) {
		Integer intFailureCauseClass = Integer.valueOf(failureCauseClass);

		Query query = em.createQuery("select DISTINCT(bd.ueTable.marketingName), bd.mccData.operator, bd.cellId, "
				+ "count(bd) " 
				+ "from BaseData bd " 
				+ "where bd.date >=:dateStart and bd.date <=:dateEnd "
				+ "and bd.failureClass.failureClass =:failureCauseClass "
				+ "group by bd.ueTable.marketingName, bd.mccData.operator, bd.cellId "
				+ "order by count(bd) DESC");

		query.setParameter("failureCauseClass", intFailureCauseClass);
		query.setParameter("dateStart", startTime);
		query.setParameter("dateEnd", finishTime);
		query.setMaxResults(10);
		List<BaseData> TopTenMarketOperatorCell_ID = query.getResultList();
		return TopTenMarketOperatorCell_ID;
	}
}
