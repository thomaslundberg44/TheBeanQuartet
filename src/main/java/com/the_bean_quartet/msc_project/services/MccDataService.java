package com.the_bean_quartet.msc_project.services;

import java.util.Collection;
import javax.ejb.Local;
import com.the_bean_quartet.msc_project.entities.MccData;


@Local
public interface MccDataService {

	public Collection<MccData> getDataset();

	public void addToDataset(MccData bData);
}
