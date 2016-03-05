package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Date;

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
				query = "select data from BaseData data where data.eventId like :eventId") 
		})

@Entity
@Table(name="base_data")
public class BaseData implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Base_Data_Id")
	private int id;

	@Column(name="Date_Time")private Date date;
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
	
//	@JoinColumn (name="Failure_Class_Id", referencedColumnName="Failure_Class")
//	@ManyToOne
//	private FailureClass failureClassTbl;
	
	public BaseData() {}
	
	public BaseData(Date date, Integer eventId, Integer failureClass, Integer ueType, 
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
	
//	@XmlTransient
//	public FailureClass getFailureClassTbl() {
//		return failureClassTbl;
//	}
//	
//	public void setFailureClassTbl(FailureClass failureClassTbl) {
//		this.failureClassTbl = failureClassTbl;
//	}
	
}
