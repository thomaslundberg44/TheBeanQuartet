package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.BaseData;

@Local
public interface BaseDataDAO {
	void addData(BaseData bData);
	void addCollectionData(Collection<BaseData> data);
    Collection<BaseData> getAllData();
    Collection<BaseData> getAllModelData();
	//Collection<BaseData> getAllModelSearchData(String model);
	Collection<BaseData> getAllModelSearchData(String model, String startTime, String finishTime);
	Collection<BaseData> getEachImsiSearchData(String startTime, String finishTime);

	Collection<BaseData> getAllIMSIData();
	/*
	 *As Customer Service Rep. I want to display, for a given affected IMSI, 
	 *the Event ID and Cause Code for any / all failures affecting that IMSI
	 *@return a collection of failure and event cause on basis of imsi
 	 * */
	Collection<BaseData> getAllIMSIRelatedData(String imsiVal);
	/*
	 * As a Support Engineer I want to see a list of all IMSIs with 
	 * call failures during a given time period
	 * @return a collection of values of failure table 
	 * */
}
