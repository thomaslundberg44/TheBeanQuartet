package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EventCauseList implements Serializable {
	
	// auto generated serial id
	private static final long serialVersionUID = 5314278365596837849L;
	
	private Collection<EventCause> events;

	public void setEventCauseCollection(Collection<EventCause> events) {
		this.events = events;
	}
	
	public Collection<EventCause> getEventCauseCollection() {
		return events;
	}

}
