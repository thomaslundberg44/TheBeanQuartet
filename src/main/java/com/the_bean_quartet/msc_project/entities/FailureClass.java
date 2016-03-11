package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="failure_class")
public class FailureClass implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = -1532221237718990741L;
	
	@Id
	@Column(name="Failure_Class_Id")
	private Integer failureClass;
	
	@Column(name="Description")private String description;
	
	
	// relationship field to Base_Data table
	@OneToMany(mappedBy="failureClass")
	private Collection<BaseData> data = new ArrayList<BaseData>();
	
	public FailureClass () { }
	
	public FailureClass(Integer failureClass, String description) {
		this.failureClass = failureClass;
		this.description = description;
	}

	public Integer getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(Integer failureClass) {
		this.failureClass = failureClass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Set<BaseData> getData() {
//		return data;
//	}
//
//	public void setData(Set<BaseData> data) {
//		this.data = data;
//	}

}