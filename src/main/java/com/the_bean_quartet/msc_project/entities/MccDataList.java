package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MccDataList implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Collection<MccData> data;

	public Collection<MccData> getData() {
		return data;
	}

	public void setMccDataCollection(Collection<MccData> data) {
		this.data = data;
	}

}
