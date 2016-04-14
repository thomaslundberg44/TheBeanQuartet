package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ue_table")
public class UETypeClass implements Serializable{
	
	// auto generated serial id
	private static final long serialVersionUID = -1532221237718990741L;
	
//	
//	@Column(name="ue_table_Id")
//	private Integer ue_table_Id;
	@Id
	@Column(name="TAC")private Integer tac;
	@Column(name="Marketing_Name")private String marketingName;
	@Column(name="Manufacturer")private String manufacturer;
	@Column(name="Access_Cpability")private String accessCapability;
	@Column(name="Model")private String model;
	@Column(name="Vendor_Name")private String vendorName;
	@Column(name="UE_Type")private String ueType;
	@Column(name="OS")private String os;
	@Column(name="Input_Mode")private String inputMode;
	
	// relationship map to base data
	@OneToMany(mappedBy="ueTable")
	@JsonIgnore
	private Set<BaseData> baseData = new HashSet<BaseData>();
	
	public UETypeClass(Integer tac, String marketingName, String manufacturer, String accessCapability, String model,
			String vendorName, String ueType, String os, String inputMode) {
		super();
		this.tac = tac;
		this.marketingName = marketingName;
		this.manufacturer = manufacturer;
		this.accessCapability = accessCapability;
		this.model = model;
		this.vendorName = vendorName;
		this.ueType = ueType;
		this.os = os;
		this.inputMode = inputMode;
	}
	public Integer getTac() {
		return tac;
	}

	public void setTac(Integer tac) {
		this.tac = tac;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAccessCapability() {
		return accessCapability;
	}

	public void setAccessCapability(String accessCapability) {
		this.accessCapability = accessCapability;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getUeType() {
		return ueType;
	}

	public void setUeType(String ueType) {
		this.ueType = ueType;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getInputMode() {
		return inputMode;
	}

	public void setInputMode(String inputMode) {
		this.inputMode = inputMode;
	}


	// relationship field to Base_Data table
	//@JoinColumn (name="ue_table_Id", referencedColumnName="ue_table")
//	@OneToOne
//	private BaseData  data;

	public UETypeClass(){}
	

//	public BaseData getData() {
//		return data;
//	}
//
//	public void setData(BaseData data) {
//		this.data = data;
//	}


}
