package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.SysUser;

@Local
public interface SysUserDAO {
	void addUser(SysUser user);
    Collection<SysUser> getAllUsers();
	boolean verify_user(SysUser user);
	Collection<SysUser> getAllUsersBy(String viewBy);
}
