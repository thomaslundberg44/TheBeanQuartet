package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.EventCause;

@Local
public interface EventCauseDAO {
	void addEvents(EventCause events);
    Collection<EventCause> getAllEvents();
    void addListEvents(Collection<EventCause> eventList);
}
