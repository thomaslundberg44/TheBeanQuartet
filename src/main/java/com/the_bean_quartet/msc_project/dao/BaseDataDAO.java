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
}
