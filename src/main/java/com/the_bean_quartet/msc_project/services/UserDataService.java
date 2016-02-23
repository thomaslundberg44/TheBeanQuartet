package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.UserData;

@Local
public interface UserDataService {

	public Collection<UserData> getUserDataset();

	public void addToUserDataset(UserData uData);
}
