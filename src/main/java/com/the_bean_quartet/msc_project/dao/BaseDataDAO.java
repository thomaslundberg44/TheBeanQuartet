package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.BaseData;

@Local
public interface BaseDataDAO {
	void addData(BaseData bData);
    Collection<BaseData> getAllData();
}
