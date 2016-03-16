package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.FailureClass;

@Local
public interface FailureDataService {
	public Collection<FailureClass> getFailureDataset();

	public void addToFailureDataset(FailureClass fData);
	
	public void addListFailureDataset(Collection<FailureClass> failureClassList);
	
	
	
}
