package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


//@NamedQueries(
//		{
//		@NamedQuery(name = "mccdata.getAll",
//				query = "select data from MccData data where data.mcc like :Mcc"), 
//		@NamedQuery(name = "mccdata.getAllMnc",
//		query = "select data from MccData data where data.mnc like :Mnc") 
//		})

@Entity
@Table(name="mcc_mnc")
public class MccData implements Serializable{

	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="Mcc")	private int mcc;
//	
//	@Column(name="Mnc")	private int mnc;
	
	@EmbeddedId private MccDataId id;
	
	@Column(name="Country")private String country;
	@Column(name="Operator")private String operator;
	
	// relationship field for BaseData table class
	@OneToMany(mappedBy="mccData", cascade={CascadeType.ALL})
	@JsonIgnore
	private Collection<BaseData> data = new ArrayList<BaseData>();
		
	public MccData(){}
	
	public MccData(Integer mcc, Integer mnc, String country, String operator){
		MccDataId id = new MccDataId();
		id.mcc=mcc;
		id.mnc=mnc;
		this.country=country;
		this.operator=operator;
	}

	public int getMcc() {
		return id.mcc;
	}

	public void setMcc(int mcc) {
		id.mcc = mcc;
	}

	public int getMnc() {
		return id.mnc;
	}

	public void setMnc(int mnc) {
		id.mnc = mnc;
	}

	public MccDataId getId() {
		return id;
	}

	public void setId(MccDataId id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}