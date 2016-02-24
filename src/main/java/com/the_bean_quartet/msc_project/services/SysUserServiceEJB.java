package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.the_bean_quartet.msc_project.dao.SysUserDAO;
import com.the_bean_quartet.msc_project.entities.SysUser;


@Stateless
@Local
@TransactionAttribute (TransactionAttributeType.REQUIRED)
public class SysUserServiceEJB implements SysUserService{
	
	@Inject
	@EJB // uses reflection
	private SysUserDAO dao;

	public void setDao(SysUserDAO dao) {
		this.dao = dao;
	}
	public void addUser(SysUser user) {		
			dao.addUser(user);
	}
	public Collection<SysUser> getUsers() {
		return dao.getAllUsers();
	}
	public boolean verifyUser(SysUser user) {
		return dao.verify_user(user);
	}
	public Collection<SysUser> getUsersBy(String viewBy) {
		return dao.getAllUsersBy(viewBy);
	}
}
