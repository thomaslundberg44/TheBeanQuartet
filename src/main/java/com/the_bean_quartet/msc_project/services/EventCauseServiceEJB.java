package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.the_bean_quartet.msc_project.dao.EventCauseDAO;
import com.the_bean_quartet.msc_project.dao.jpa.JPAEventCauseDAO;
import com.the_bean_quartet.msc_project.entities.EventCause;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EventCauseServiceEJB implements EventCauseService {
	
	@EJB
	private EventCauseDAO eventDao;

	public EventCauseDAO getDao() {
		return eventDao;
	}

	public void setDao(JPAEventCauseDAO dao) {
		this.eventDao = dao;
	}

	public Collection<EventCause> getEventCauseDataset() {
		return eventDao.getAllEvents();
	}

	public void addToEventCauseDataset(EventCause data) {
		eventDao.addEvents(data);
	}

}
