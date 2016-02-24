package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

public interface DAO <E> {
	void addData(E bData);
    Collection<E> getAllData();
}
