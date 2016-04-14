package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="event_cause")
@XmlRootElement
public class EventCause implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 7857838356841390003L;
	
	@EmbeddedId private EventCauseId id;

	@Column(name="Description") private String description;
	
	// relationship field for BaseData table class
	@OneToMany(mappedBy="eventCause")
	@JsonIgnore
	private Collection<BaseData> data = new ArrayList<BaseData>();
	
	public EventCause() {}
	
	public EventCause(Integer eventId, Integer causeCode, String description) {
		EventCauseId id = new EventCauseId();
		id.setEventId(eventId);
		id.setCauseCode(causeCode);
		this.id = id;
		this.description = description;
	}
	
	public Integer getEventId() {
		return id.getEventId();
	}
	
	public Integer getCauseCode() {
		return id.getCauseCode();
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
