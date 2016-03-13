package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EventCauseId implements Serializable {
	
	// auto generated serial id
	private static final long serialVersionUID = 2435367681693913886L;

	@Column(name="Cause_Code")Integer causeCode;
	@Column(name="Event_Id")Integer eventId;

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

	@Override
	public int hashCode() {
		return Objects.hashCode(causeCode+eventId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EventCauseId))
			return false;
		EventCauseId other = (EventCauseId)obj;
		return (other.causeCode.equals(this.causeCode) 
				&& other.eventId.equals(this.eventId));
	}

}
