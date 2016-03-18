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


	Collection<BaseData> getAllIMSIData();
	/*
	 *As Customer Service Rep. I want to display, for a given affected IMSI, 
	 *the Event ID and Cause Code for any / all failures affecting that IMSI
	 *@return a collection of failure and event cause on basis of imsi
 	 * */
	Collection<BaseData> getAllIMSIRelatedData(String imsiVal);
	/*
	 * used to remove the entries out of baseData
	 * */
	
}
