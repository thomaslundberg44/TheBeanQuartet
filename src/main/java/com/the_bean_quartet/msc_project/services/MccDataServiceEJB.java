package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.MccMncDataDAO;
import com.the_bean_quartet.msc_project.entities.MccData;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class MccDataServiceEJB implements MccDataService{

	@Inject // uses reflection
	private MccMncDataDAO dao;
	public Collection<MccData> getDataset() {
		
		return dao.getAllMccData();
	}

	public MccMncDataDAO getDao() {
		return dao;
	}

	public void setDao(MccMncDataDAO dao) {
		this.dao = dao;
	}

	public void addToDataset(MccData bData) {
		
		dao.addData(bData);
	}

	public void addListToDataset(Collection<MccData> dataList) {
		dao.addListData(dataList);
	}

}
