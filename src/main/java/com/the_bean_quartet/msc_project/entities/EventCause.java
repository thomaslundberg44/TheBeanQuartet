package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable 
class EventCauseId2 implements java.io.Serializable {
	// auto generated serial id
	private static final long serialVersionUID = 4445553741072449878L;
	
	@Column(name="Cause_Code")Integer causeCode;
	@Column(name="Event_Id")Integer eventId;
}

@Entity
@Table(name="event_cause")
public class EventCause implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 7857838356841390003L;
	
	@Id private EventCauseId2 id;
	
	@Column(name="Description") private String description;
	
	// relationship field for BaseData table class
//	@JoinColumn(name="Cause_Code", referencedColumnName="id", nullable=false)
//	@ManyToOne
//	private BaseData data;
	
	public EventCause() {}
	
	public EventCause(Integer causeCode, Integer eventId, String description) {
		id.causeCode = causeCode;
		id.eventId = eventId;
		this.description = description;
	}

	public Integer getCauseCode() {
		return id.causeCode;
	}

	public void setCauseCode(Integer causeCode) {
		id.causeCode = causeCode;
	}

	public Integer getEventId() {
		return id.eventId;
	}

	public void setEventId(Integer eventId) {
		id.eventId = eventId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
