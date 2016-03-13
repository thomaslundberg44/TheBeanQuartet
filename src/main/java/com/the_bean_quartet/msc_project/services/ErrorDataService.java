package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.ErrorData;

@Local
public interface ErrorDataService {

	public Collection<ErrorData> getErrorData();

	public void addToErrorData(ErrorData eData);
	
	public void addListErrorData(Collection<ErrorData> errorList);
	
}
