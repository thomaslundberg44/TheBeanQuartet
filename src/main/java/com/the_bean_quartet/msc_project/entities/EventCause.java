package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="event_cause")
public class EventCause implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 7857838356841390003L;
	
	@EmbeddedId private EventCauseId id;

	public EventCauseId getId() {
		return id;
	}

	public void setId(EventCauseId id) {
		this.id = id;
	}

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
