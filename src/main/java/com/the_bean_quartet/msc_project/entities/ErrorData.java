package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="error_data")
public class ErrorData implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = -1778697005477706872L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Date_Time")private String date;
	@Column(name="Event_Id")private Integer eventId;
	@Column(name="Failure_Class")private Integer failureClass;
	@Column(name="UE_Type")private Integer ueType;
	@Column(name="Market")private Integer market;
	@Column(name="Operator")private Integer operator;
	@Column(name="Cell_Id")private Integer cellId;
	@Column(name="Duration")private Integer duration;
	@Column(name="Cause_Code")private Integer causeCode;
	@Column(name="NE_Version")private String neVersion;
	@Column(name="IMSI")private Long imsi;
	@Column(name="HIER3_ID")private Long heir3Id;
	@Column(name="HIER32_ID")private Long heir32Id;
	@Column(name="HIER321_ID")private Long heir321Id;
	
	// relationship field for failure class table mapping
	
	@OneToOne(mappedBy="data")
	private FailureClass failureClassTbl;
	
	public ErrorData() {}
	
	public ErrorData(String date, Integer eventId, Integer failureClass, Integer ueType, 
			Integer market, Integer operator, Integer cellId, Integer duration, Integer causeCode,
			String neVersion, Long imsi, Long heir3Id, Long heir32Id, Long heir321Id) {
		this.date = date;
		this.eventId = eventId;
		this.failureClass = failureClass;
		this.ueType = ueType;
		this.market = market;
		this.operator = operator;
		this.cellId = cellId;
		this.duration = duration;
		this.causeCode = causeCode;
		this.neVersion = neVersion;
		this.imsi = imsi;
		this.heir3Id = heir3Id;
		this.heir32Id = heir32Id;
		this.heir321Id = heir321Id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getMarket() {
		return market;
	}

	public void setMarket(Integer market) {
		this.market = market;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public Integer getCellId() {
		return cellId;
	}

	public void setCellId(Integer cellId) {
		this.cellId = cellId;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(Integer causeCode) {
		this.causeCode = causeCode;
	}

	public String getNeVersion() {
		return neVersion;
	}

	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}

	public Long getImsi() {
		return imsi;
	}

	public void setImsi(Long imsi) {
		this.imsi = imsi;
	}

	public Long getHeir3Id() {
		return heir3Id;
	}

	public void setHeir3Id(Long heir3Id) {
		this.heir3Id = heir3Id;
	}

	public Long getHeir32Id() {
		return heir32Id;
	}

	public void setHeir32Id(Long heir32Id) {
		this.heir32Id = heir32Id;
	}

	public Long getHeir321Id() {
		return heir321Id;
	}

	public void setHeir321Id(Long heir321Id) {
		this.heir321Id = heir321Id;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}


	public Integer getUeType() {
		return ueType;
	}

	public void setUeType(Integer ueType) {
		this.ueType = ueType;
	}

	public Integer getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(Integer failureClass) {
		this.failureClass = failureClass;
	}
}
