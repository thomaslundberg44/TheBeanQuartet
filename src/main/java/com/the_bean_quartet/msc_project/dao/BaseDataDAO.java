package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.BaseData;

@Local
public interface BaseDataDAO {
	void addData(BaseData bData);
    Collection<BaseData> getAllData();
	Collection<BaseData> getAllIMSIData();
	Collection<BaseData> getAllIMSIRelatedData(String imsiVal);
	
}
