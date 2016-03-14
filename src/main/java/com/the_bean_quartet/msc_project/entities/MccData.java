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
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="mcc_mnc")
@XmlRootElement
@IdClass(MccDataId.class)
public class MccData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @Column(name="Mcc") private int Mcc ;
	@Id @Column(name="Mnc") private int Mnc;
	@Column(name="Country")private String country;
	@Column(name="Operator")private String operator;
	
	// relationship field for BaseData table class
	@OneToMany(mappedBy="mccData", cascade={CascadeType.ALL})
	@JsonIgnore
	private Collection<BaseData> data = new ArrayList<BaseData>();
		
	public MccData(){}
	
	public MccData(Integer mcc, Integer mnc, String country, String operator){
		this.Mcc=mcc;
		this.Mnc=mnc;
		this.country=country;
		this.operator=operator;
	}

	public int getMcc() {
		return Mcc;
	}

	public void setMcc(int mcc) {
		Mcc = mcc;
	}

	public int getMnc() {
		return Mnc;
	}

	public void setMnc(int mnc) {
		Mnc = mnc;
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

	public Collection<BaseData> getData() {
		return data;
	}

	public void setData(Collection<BaseData> data) {
		this.data = data;
	}

	
}