package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.FailureClassDAO;
import com.the_bean_quartet.msc_project.entities.FailureClass;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class FailureDataServiceEJB implements FailureDataService{
	@EJB
	private FailureClassDAO failuresDAO;

	
	public FailureClassDAO getFailuresDAO() {
		return failuresDAO;
	}

	public void setFailuresDAO(FailureClassDAO failuresDAO) {
		this.failuresDAO = failuresDAO;
	}


	public Collection<FailureClass> getFailureDataset() {
		return failuresDAO.getAllFailures();
	}

	public void addToFailureDataset(FailureClass fData) {
		failuresDAO.addFailures(fData);
	}

	public void addListFailureDataset(Collection<FailureClass> failureClassList) {
		failuresDAO.addListFailures(failureClassList);
	}
	
}
