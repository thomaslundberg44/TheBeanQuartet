package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.BaseData;


@Local
public interface BaseDataService {

	public Collection<BaseData> getDataset();

	public void addToDataset(BaseData bData);



}
