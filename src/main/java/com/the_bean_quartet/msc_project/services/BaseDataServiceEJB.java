package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.BaseDataDAO;
import com.the_bean_quartet.msc_project.dao.FailureClassDAO;
import com.the_bean_quartet.msc_project.dao.UETypeClassDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.FailureClass;
import com.the_bean_quartet.msc_project.entities.UETypeClass;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BaseDataServiceEJB implements BaseDataService {

	@EJB // uses reflection
	private BaseDataDAO baseDAO;


	

	// @Resource
	// private SessionContext context;



	public void setDao(BaseDataDAO dao) {
		// do something really important on injection
		this.baseDAO = dao;
	}

	public void addToDataset(BaseData bData) {

		baseDAO.addData(bData);

	}

	public Collection<BaseData> getDataset() {
		return baseDAO.getAllData();
	}


	

}
