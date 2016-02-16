package com.the_bean_quartet.msc_project.services;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.BaseData;

import java.util.Collection;

@Local
	public interface BaseDataService {

		public Collection<BaseData> getDataset() ;
		public void addToDataset(BaseData bData);
		
	}


