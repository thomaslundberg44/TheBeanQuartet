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

import com.the_bean_quartet.msc_project.dao.EventCauseDAO;
import com.the_bean_quartet.msc_project.entities.EventCause;

@Stateless
@Local
public class JPAEventCauseDAO implements EventCauseDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void addEvents(EventCause event) {
		Query query = em.createQuery("from EventCause");
		List<EventCause> events = query.getResultList(); 
		if (!events.contains(event))
			em.persist(event);
	}
	
	public void deleteAllEntries() {
		Query query = em.createQuery("DELETE from EventCause");
		query.executeUpdate();
	}

	public Collection<EventCause> getAllEvents() {
		Query query = em.createQuery("from EventCause");
		List<EventCause> events = query.getResultList(); 
		return events;
	}

	@TransactionAttribute (TransactionAttributeType.REQUIRES_NEW)
	public void addListEvents(Collection<EventCause> eventList) {
		Query query = em.createQuery("from EventCause");
		List<EventCause> events = query.getResultList();
		for(EventCause event : eventList) {
			if(!events.contains(event))
				em.merge(event);
		}
	}

//	public void addData(Object bData) {
//		Query query = em.createQuery("from EventCause");
//		List<Object> data = query.getResultList(); 
//		if (!data.contains(bData))
//			em.persist(bData);
//	}
//
//	public Collection getAllData() {
//		Query query = em.createQuery("from EventCause");
//		List<EventCause> data = query.getResultList(); 
//		return data;
//	}

}
