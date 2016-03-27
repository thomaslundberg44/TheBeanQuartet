package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.BaseData;

@Local
public interface BaseDataDAO {
	void addData(BaseData bData);
	void deleteAllEntries();
	void addCollectionData(Collection<BaseData> data);
    Collection<BaseData> getAllData();
    Collection<BaseData> getAllModelData();
	//Collection<BaseData> getAllModelSearchData(String model);
	Collection<BaseData> getAllModelSearchData(String model, String startTime, String finishTime);
	Collection<BaseData> getEachImsiSearchData(String startTime, String finishTime);
	Collection<BaseData> getListImsiWithFailureTimeRange(String startTime, String finishTime);
	Collection<BaseData> getCauseCodeWithCallFailureForAnImsi(String imsi);


	Collection<BaseData> getAllIMSIData();
	
	/*
	 *user story 12
 	 * */
	Collection<BaseData> getTop10ImsiSearchData(String startTime,String finishTime);
	
	Collection<BaseData> getAllIMSIRelatedData(String imsiVal);
	/*
	 * user story 5
	 * */
	Collection<BaseData> getImsiFailureCount(String imsiValue,String startTime, String finishTime);
	
	
}
