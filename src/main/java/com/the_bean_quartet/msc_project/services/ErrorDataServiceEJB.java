package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.the_bean_quartet.msc_project.dao.ErrorDataDAO;
import com.the_bean_quartet.msc_project.entities.ErrorData;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ErrorDataServiceEJB implements ErrorDataService {
	
	@EJB // uses reflection
	private ErrorDataDAO errorDAO;

	public Collection<ErrorData> getErrorData() {
		return errorDAO.getAllData();
	}

	public void addToErrorData(ErrorData eData) {
		errorDAO.addData(eData);
	}

	public ErrorDataDAO getErrorDAO() {
		return errorDAO;
	}

	public void setErrorDAO(ErrorDataDAO errorDAO) {
		this.errorDAO = errorDAO;
	}

}
