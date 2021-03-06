package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.EventCauseDAO;
import com.the_bean_quartet.msc_project.dao.jpa.JPAEventCauseDAO;
import com.the_bean_quartet.msc_project.entities.EventCause;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EventCauseServiceEJB implements EventCauseService {
	
	
	@Inject
	private EventCauseDAO eventDao;

	public EventCauseDAO getDao() {
		return eventDao;
	}

	public void setDao(JPAEventCauseDAO dao) {
		this.eventDao = dao;
	}
	
//	@EJB
//	private DAO dao;
//
//	public DAO getDao() {
//		return dao;
//	}
//
//	public void setDao(DAO dao) {
//		this.dao = dao;
//	}

	public Collection<EventCause> getEventCauseDataset() {
		return eventDao.getAllEvents();
	}

	public void addToEventCauseDataset(EventCause data) {
		eventDao.addEvents(data);
	}

	public void addListEventCauseDataset(Collection<EventCause> eventList) {
		eventDao.addListEvents(eventList);
	}

//	public Collection getDataset() {
//		return dao.getAllData();
//	}
//
//	public void addToDataset(Object data) {
//		dao.addData(data);
//	}

}
