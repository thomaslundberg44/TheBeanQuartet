package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//
//@NamedQueries({
//		@NamedQuery(name = "basedata.getAll", query = "select data from BaseData data where data.eventId like :eventId") })

@Entity
@Table(name = "base_data")
public class BaseData implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Base_Data_Id") private int id;
	@Column(name = "Date_Time") private String date;
	@Column(name = "Cell_Id") private Integer cellId;
	@Column(name = "Duration") private Integer duration;
	@Column(name = "NE_Version") private String neVersion;
	@Column(name = "IMSI") private Long imsi;
	@Column(name = "HIER3_ID") private Long heir3Id;
	@Column(name = "HIER32_ID") private Long heir32Id;
	@Column(name = "HIER321_ID") private Long heir321Id;

	// relationship mapping for other tables
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "Event_Id", referencedColumnName = "Event_Id"),
			@JoinColumn(name = "Cause_Code", referencedColumnName = "Cause_Code") })
	private EventCause eventCause;
	
	@ManyToOne
	@JoinColumn(name="Failure_Class", referencedColumnName="Failure_Class_Id")
	private FailureClass failureClass;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Market", referencedColumnName = "Mcc"),
		@JoinColumn(name="Operator", referencedColumnName = "Mnc")
	})
	private MccData mccData;

	@ManyToOne
	@JoinColumn(name = "UE_Type", referencedColumnName = "Tac")
	private UETypeClass ueTable;

	public BaseData() {}

	public BaseData(String date, FailureClass failureClass, MccData mccData, Integer cellId, Integer duration,
			String neVersion, Long imsi, Long heir3Id, Long heir32Id, Long heir321Id, EventCause eventCause,
			UETypeClass ueTable) {
		this.date = date;
		this.failureClass = failureClass;
		this.mccData = mccData;
		this.cellId = cellId;
		this.duration = duration;
		this.neVersion = neVersion;
		this.imsi = imsi;
		this.heir3Id = heir3Id;
		this.heir32Id = heir32Id;
		this.heir321Id = heir321Id;
		this.eventCause = eventCause;
		this.ueTable = ueTable;
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
	
	// relationship getter/setters

	public void setFailureClass(FailureClass failureClass) {
		this.failureClass = failureClass;
	}

	public FailureClass getFailureClass() {
		return failureClass;
	}

	public EventCause getEventCause() {
		return eventCause;
	}

	public void setEventCause(EventCause eventCause) {
		this.eventCause = eventCause;
	}
	
	public MccData getMccData() {
		return mccData;
	}

	public void setMccData(MccData mccData) {
		this.mccData = mccData;
	}

	public UETypeClass getUeTable() {
		return ueTable;
	}

	public void setUeTable(UETypeClass ueTable) {
		this.ueTable = ueTable;
	}
}
