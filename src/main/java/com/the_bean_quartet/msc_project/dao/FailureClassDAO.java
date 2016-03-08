package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import com.the_bean_quartet.msc_project.entities.FailureClass;

public interface FailureClassDAO {
	void addFailures(FailureClass failures);
    Collection<FailureClass> getAllFailures();
    void addListFailures(Collection<FailureClass> failureClassList);
}
