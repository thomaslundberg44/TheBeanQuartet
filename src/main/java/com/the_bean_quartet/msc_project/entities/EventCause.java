//package com.the_bean_quartet.msc_project.entities;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="event_cause")
//public class EventCause implements Serializable {
//
//	// auto generated serial id
//	private static final long serialVersionUID = 7857838356841390003L;
//	
//	@Id
//	@Column(name="Cause_Code")private Integer causeCode;
//	@Id
//	@Column(name="Event_Id")private Integer eventId;
//	@Column(name="Description")private String description;
//	
//	// relationship field for BaseData table class
//	@JoinColumn(name="Cause_Code", referencedColumnName="id", nullable=false)
//	@ManyToOne
//	private BaseData data;
//	
//	public EventCause() {}
//	
//	public EventCause(Integer causeCode, Integer eventId, String description) {
//		this.causeCode = causeCode;
//		this.eventId = eventId;
//		this.description = description;
//	}
//
//	public Integer getCauseCode() {
//		return causeCode;
//	}
//
//	public void setCauseCode(Integer causeCode) {
//		this.causeCode = causeCode;
//	}
//
//	public Integer getEventId() {
//		return eventId;
//	}
//
//	public void setEventId(Integer eventId) {
//		this.eventId = eventId;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
//}
