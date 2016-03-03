package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.ErrorData;

@Local
public interface ErrorDataDAO {
	void addData(ErrorData eData);
    Collection<ErrorData> getAllData();
}
