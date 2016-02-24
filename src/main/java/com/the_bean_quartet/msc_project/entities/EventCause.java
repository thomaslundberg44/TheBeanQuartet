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

	@Column(name="Description") private String description;
	
	// relationship field for BaseData table class
//	@JoinColumn(name="Cause_Code", referencedColumnName="id", nullable=false)
//	@ManyToOne
//	private BaseData data;
	
	public EventCause() {}
	
	public EventCause(Integer eventId, Integer causeCode, String description) {
		EventCauseId id = new EventCauseId();
		id.setEventId(1234);
		id.setCauseCode(4321);
		this.id = id;
		this.description = description;
	}
	
	public EventCauseId getId() {
		return id;
	}

	public void setId(EventCauseId id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
