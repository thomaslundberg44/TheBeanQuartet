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
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="event_cause")
@XmlRootElement
@IdClass(EventCauseId.class)
public class EventCause implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 7857838356841390003L;
	
	@Id @Column(name="Cause_Code") private int causeCode;
	@Id @Column(name="Event_Id") private int eventId;
	@Column(name="Description") private String description;
	
	// relationship field for BaseData table class
	@OneToMany(mappedBy="eventCause", cascade={CascadeType.ALL})
	@JsonIgnore
	private Collection<BaseData> data = new ArrayList<BaseData>();
	
	public EventCause() {}
	
	public EventCause(int causeCode, int eventId, String description){
		this.causeCode = causeCode;
		this.eventId = eventId;
		this.description = description;
		
	}

	public int getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(int causeCode) {
		this.causeCode = causeCode;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + causeCode;
		result = prime * result + eventId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventCause other = (EventCause) obj;
		if (causeCode != other.causeCode)
			return false;
		if(eventId != other.eventId)
			return false;
		return true;
	}

	public Collection<BaseData> getData() {
		return data;
	}

	public void setData(Collection<BaseData> data) {
		this.data = data;
	}
	
}