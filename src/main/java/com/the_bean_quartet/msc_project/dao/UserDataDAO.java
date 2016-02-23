package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.UserData;

@Local
public interface UserDataDAO {
	void addData(UserData uData);
    Collection<UserData> getAllUserData();
}
