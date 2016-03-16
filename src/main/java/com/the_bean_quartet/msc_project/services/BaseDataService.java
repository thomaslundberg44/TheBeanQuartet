package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.BaseData;


@Local
public interface BaseDataService {
	

	public Collection<BaseData> getDataset();

	public void addToDataset(BaseData bData);
	
	public void addCollectionToDataset(Collection<BaseData> data);
	
	public Collection<BaseData> getModelData();
	
	public Collection<BaseData> getSelectedModelBaseData(String model, String startTime, String finishTime);

	public Collection<BaseData> getEachImsiBaseData(String startTime, String finishTime);
	
	public Collection<BaseData> getListImsiWithFailureTimeRange(String startTime, String finishTime);

	public Collection<BaseData> getIMSIData();
	
	public Collection<BaseData> getSelectedBaseData(String imsiValue);
}
