package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;


import com.the_bean_quartet.msc_project.entities.UETypeClass;

public interface UETypeClassDAO {
	
	void addUE(UETypeClass UEType);
    Collection<UETypeClass> getAllUEType();
	void addListUE(Collection<UETypeClass> ueList);
}
