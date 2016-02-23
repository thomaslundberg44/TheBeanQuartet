package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.the_bean_quartet.msc_project.dao.BaseDataDAO;
import com.the_bean_quartet.msc_project.dao.UserDataDAO;
import com.the_bean_quartet.msc_project.entities.UserData;

@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class UserDataServiceEJB implements UserDataService {
	
	@EJB // uses reflection
	private UserDataDAO dao;

	public Collection<UserData> getUserDataset() {
		// TODO Auto-generated method stub
		return dao.getAllUserData();
	}

	public UserDataDAO getDao() {
		return dao;
	}

	public void setDao(UserDataDAO dao) {
		this.dao = dao;
	}

	public void addToUserDataset(UserData uData) {
		dao.addData(uData);
		
	}

	

	

	
}
