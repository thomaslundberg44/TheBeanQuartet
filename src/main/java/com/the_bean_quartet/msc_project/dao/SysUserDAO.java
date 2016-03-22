package com.the_bean_quartet.msc_project.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.SysUser;

@Local
public interface SysUserDAO {
	String addUser(SysUser user);
    Collection<SysUser> getAllUsers();
	String verify_user(SysUser user);
	Collection<SysUser> getAllUsersBy(String viewBy);
	void deleteAllEntries();
	String changeUsername(String id, String variable);
	String deleteUser(String id);
	String changeUserType(String id, String variable);
	String changeUserPassword(String id, String variable);
}
