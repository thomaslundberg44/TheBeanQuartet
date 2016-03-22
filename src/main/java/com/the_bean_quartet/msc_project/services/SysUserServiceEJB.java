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
	public String addUser(SysUser user) {		
			
			return dao.addUser(user);
	}
	public Collection<SysUser> getUsers() {
		return dao.getAllUsers();
	}
	public String verifyUser(SysUser user) {
		return dao.verify_user(user);
	}
	public Collection<SysUser> getUsersBy(String viewBy) {
		return dao.getAllUsersBy(viewBy);
	}
	public String changeUsername(String id, String variable) {
		// TODO Auto-generated method stub
		return dao.changeUsername(id, variable);
	}
	public String deleteUser(String id) {
		// TODO Auto-generated method stub
		return dao.deleteUser(id);
	}
	public String changeUserType(String id, String variable) {
		// TODO Auto-generated method stub
		return dao.changeUserType(id, variable);
	}
	public String changeUserPassword(String id, String variable) {
		// TODO Auto-generated method stub
		return dao.changeUserPassword(id, variable) ;
	}
}
