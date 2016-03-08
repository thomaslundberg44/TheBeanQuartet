package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.UETypeClassDAO;
import com.the_bean_quartet.msc_project.entities.UETypeClass;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UETypeServiceJEJB implements UETypeService{

	@EJB
	private UETypeClassDAO ueTypeClassDAO;


	public UETypeClassDAO getUeTypeClassDAO() {
		return ueTypeClassDAO;
	}

	public void setUeTypeClassDAO(UETypeClassDAO ueTypeClassDAO) {
		this.ueTypeClassDAO = ueTypeClassDAO;
	}


	public Collection<UETypeClass> getUEDataset() {
		return ueTypeClassDAO.getAllUEType();
	}

	public void addToUEDataset(UETypeClass ueData) {
		ueTypeClassDAO.addUE(ueData);		
	}

	public void addListUEDataset(Collection<UETypeClass> ueList) {
		ueTypeClassDAO.addListUE(ueList);
	}
}
