package com.the_bean_quartet.msc_project.entities;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FailureDataList {

	// auto generated serial id
	private static final long serialVersionUID = 1L;

	private Collection<FailureClass> failures;

	public Collection<FailureClass> getFailureDataCollection() {
		return failures;
	}

	public void setFailureDataCollection(Collection<FailureClass> failures) {
		this.failures = failures;
	}
}
