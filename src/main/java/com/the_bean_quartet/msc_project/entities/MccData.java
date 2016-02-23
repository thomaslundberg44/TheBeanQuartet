package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries(
		{
		@NamedQuery(name = "mccdata.getAll",
				query = "select data from MccData data where data.mcc like :Mcc"), 
		@NamedQuery(name = "mccdata.getAllMnc",
		query = "select data from MccData data where data.mnc like :Mnc") 
		})

@Entity
@Table(name="mcc_mnc")
public class MccData implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Mcc")	private int mcc;
	
	@Column(name="Mnc")	private int mnc;
	@Column(name="Country")private String country;
	@Column(name="Operator")private String operator;
		
	public MccData(){}
	
	public MccData(Integer mcc, Integer mnc, String country, String operator){
		this.mcc=mcc;
		this.mnc=mnc;
		this.country=country;
		this.operator=operator;
	}

	public int getMcc() {
		return mcc;
	}

	public void setMcc(int mcc) {
		this.mcc = mcc;
	}

	public int getMnc() {
		return mnc;
	}

	public void setMnc(int mnc) {
		this.mnc = mnc;
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


