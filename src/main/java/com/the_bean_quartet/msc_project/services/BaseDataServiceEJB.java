package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.the_bean_quartet.msc_project.dao.BaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BaseDataServiceEJB implements BaseDataService {

	@EJB // uses reflection
	private BaseDataDAO baseDAO;

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

	public void addCollectionToDataset(Collection<BaseData> data) {
		baseDAO.addCollectionData(data);
	}
	public Collection<BaseData> getModelData() {
		return baseDAO.getAllModelData();
	}

	public Collection<BaseData> getSelectedModelBaseData(String model,String startTime, String finishTime) {
		return baseDAO.getAllModelSearchData(model, startTime, finishTime);
	}
	
	public Collection<BaseData> getIMSIData() {
		return baseDAO.getAllIMSIData();
	}
	
	public Collection<BaseData>getSelectedBaseData(String imsiVal)
	{
		return baseDAO.getAllIMSIRelatedData(imsiVal);
	}
	
	public Collection<BaseData>getCauseCodeWithCallFailureForAnImsi(String imsi)
	{
		return baseDAO.getCauseCodeWithCallFailureForAnImsi(imsi);
		
	}
	public Collection<BaseData> getEachImsiBaseData(String startTime, String finishTime){
		
		return baseDAO.getEachImsiSearchData(startTime, finishTime);
	}
	public Collection<BaseData> getListImsiWithFailureTimeRange(String startTime, String finishTime){
		return baseDAO.getListImsiWithFailureTimeRange(startTime, finishTime);
	}

	public Collection<BaseData> getTop10ImsiBaseData(String startTime, String finishTime) {
		return baseDAO.getTop10ImsiSearchData(startTime, finishTime);
	}

	public Collection<BaseData> getImsiFailureCount(String imsiValue,String startTime, String finishTime) {
		return baseDAO.getImsiFailureCount(imsiValue,startTime, finishTime);
	}

}
