package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


public class EventCauseId implements Serializable {
	
	// auto generated serial id
	private static final long serialVersionUID = 2435367681693913886L;

	private int causeCode;
	private int eventId;
	
	public EventCauseId() {}

	public EventCauseId(int eventId, int causeCode) {
		super();
		this.eventId = eventId;
		this.causeCode = causeCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventCauseId other = (EventCauseId) obj;
		if (eventId != other.eventId)
			return false;
		if(causeCode != other.causeCode)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
		result = prime * result + causeCode;
		
		return result;
	}
		

	public Integer getCauseCode() {
		return causeCode;
	}
	
	public Integer getEventId() {
		return eventId;
	}
	
	public void setCauseCode(Integer causeCode) {
		this.causeCode = causeCode;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

		
}