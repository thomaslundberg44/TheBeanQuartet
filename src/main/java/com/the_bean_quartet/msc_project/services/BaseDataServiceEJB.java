package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.BaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;

@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BaseDataServiceEJB implements BaseDataService {

	@Inject // uses reflection
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
		System.out.println("In Base Data Service: Adding collection of size: "+data.size());
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
//	public Collection<Object[]> getTop10ImsiBaseData(String startTime, String finishTime) {
//		return baseDAO.getTop10ImsiSearchData(startTime, finishTime);
//	}

	public Collection<BaseData> getImsiFailureCount(String imsiValue,String startTime, String finishTime) {
		return baseDAO.getImsiFailureCount(imsiValue,startTime, finishTime);
	}


	public Collection<BaseData> getSelectedModelEventCauseData(String model) {
		return baseDAO.getAllModelEventCauseData(model);
	}


	public Collection<BaseData> getAllFailureCauseClass(){
		return baseDAO.getAllFailureCauseClass();
	}
	public Collection<BaseData> getImsiForAnFailureCauseClass(String failureCauseClass){
		return baseDAO.getImsiForAnFailureCauseClass(failureCauseClass);
	}
	public Collection<BaseData> getTopTenMarketOperatorCell_ID(String failureCauseClass, String startTime, String finishTime) {
		return baseDAO.getTopTenMarketOperatorCell_ID(failureCauseClass, startTime, finishTime);


	}

}
