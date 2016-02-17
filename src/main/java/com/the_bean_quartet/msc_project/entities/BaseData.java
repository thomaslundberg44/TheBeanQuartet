package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries(
		{
		@NamedQuery(name = "basedata.getAll",
				query = "select data from BaseData data where data.eventId > :eventId") 
		})

@Entity
@Table(name="Base_Data")
public class BaseData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@Column(name = "date")private String date;
	@Column(name="eventId")private Integer eventId;
	@Column(name="failureClass")private Integer failureClass;
	@Column(name="UEType")private Integer UEType;
	
	public BaseData() {}
	
	public BaseData(Integer eventId, Integer failureClass, Integer UEType) {
		//this.date = date;
		this.eventId = eventId;
		this.failureClass = failureClass;
		this.UEType = UEType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(Integer failureClass) {
		this.failureClass = failureClass;
	}

	public Integer getUEType() {
		return UEType;
	}

	public void setUEType(Integer uEType) {
		UEType = uEType;
	}
	
	// might need relationship to failure class etc

}
