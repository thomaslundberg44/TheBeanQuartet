package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.EventCause;

@Local
public interface EventCauseService {

	public Collection<EventCause> getEventCauseDataset();

	public void addToEventCauseDataset(EventCause event);
	
	public void addListEventCauseDataset(Collection<EventCause> eventList);

}
