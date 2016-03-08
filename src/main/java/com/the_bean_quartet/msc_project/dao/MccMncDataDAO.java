package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.MccData;
@Local
public interface MccMncDataDAO {
	
	void addData(MccData uData);
    Collection<MccData> getAllMccData();
    void addListData(Collection<MccData> dataList);
}
