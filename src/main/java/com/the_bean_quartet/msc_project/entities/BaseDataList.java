package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseDataList implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 1L;
	
	private Collection<BaseData> data;
	
	public Collection<BaseData> getBaseDataCollection() {
		return data;
	}
	
	public void setBaseDataCollection(Collection<BaseData> data) {
		this.data = data;
	}
	
}
