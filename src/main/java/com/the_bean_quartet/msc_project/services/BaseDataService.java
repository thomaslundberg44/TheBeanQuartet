package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.FailureClass;
import com.the_bean_quartet.msc_project.entities.UETypeClass;

@Local
public interface BaseDataService {

	public Collection<BaseData> getDataset();

	public void addToDataset(BaseData bData);

	public Collection<FailureClass> getFailureDataset();

	public void addToFailureDataset(FailureClass fData);

	public Collection<UETypeClass> getUEDataset();

	public void addToUEDataset(UETypeClass ueData);

}
