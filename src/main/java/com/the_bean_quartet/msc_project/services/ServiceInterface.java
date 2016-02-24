package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

public interface ServiceInterface <E> {
	
	public Collection<E> getDataset();

	public void addToDataset(E data);
}
