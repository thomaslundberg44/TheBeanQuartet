package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.FailureClass;

@Local
public interface BaseDataDAO {
	void addData(BaseData bData);
	/**
	 * Queries the Base data table for all the data inside the table
	 * @return a collection of Base Data table rows
	 */
    Collection<BaseData> getAllData();
    /*
     * Queries the Base data table to select all the distinct imsi inside table
     * @return a collection of distinct values of imsi data
     * */
	Collection<BaseData> getAllIMSIData();
	/*
     * Queries the Base data table to select all the distinct dates inside table
     * @return a collection of distinct values of date data
     * */
	Collection<BaseData> getDateData();
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
	Collection<BaseData> getImsiList(String date1, String date2);
	
}
