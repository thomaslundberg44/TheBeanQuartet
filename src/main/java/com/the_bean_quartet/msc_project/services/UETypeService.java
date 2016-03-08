package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.UETypeClass;

@Local
public interface UETypeService {
	public Collection<UETypeClass> getUEDataset();

	public void addToUEDataset(UETypeClass ueData);

	public void addListUEDataset(Collection<UETypeClass> ueList);
}
