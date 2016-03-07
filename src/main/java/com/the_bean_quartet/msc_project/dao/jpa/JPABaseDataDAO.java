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
		System.out.println("Inserting entities from list into DB...");
		long startTime = System.currentTimeMillis();
		for(BaseData dataItem : data) {
			if(!dataList.contains(dataItem))
			em.persist(dataItem);
		}
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("Total time to insert entities: "+duration/1000.0+" seconds");
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
}
