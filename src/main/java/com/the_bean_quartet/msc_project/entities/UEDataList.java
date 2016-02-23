package com.the_bean_quartet.msc_project.entities;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UEDataList {

	// auto generated serial id
	private static final long serialVersionUID = 1L;

	private Collection<UETypeClass> UEType;

	public Collection<UETypeClass> getUEDataCollection() {
		return UEType;
	}

	public void setUEDataCollection(Collection<UETypeClass> UEType) {
		this.UEType = UEType;
	}
}

