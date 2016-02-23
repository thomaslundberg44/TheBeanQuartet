package com.the_bean_quartet.msc_project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDataList implements Serializable {


	private static final long serialVersionUID = 1L;

	private Collection<UserData> userData;
	
	public Collection<UserData> getUserData() {
		return userData;
	}

	public void setUserData(Collection<UserData> userData) {
		this.userData = userData;
	}
	
	public UserDataList(){}
	
}
