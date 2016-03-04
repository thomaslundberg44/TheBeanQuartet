package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

public class ErrorDataList implements Serializable {

	// auto generated serial id
	private static final long serialVersionUID = 1L;
	
	private Collection<ErrorData> data;
	
	public Collection<ErrorData> getErrorDataCollection() {
		return data;
	}
	
	public void setErrorDataCollection(Collection<ErrorData> data) {
		this.data = data;
	}
}
