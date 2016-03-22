package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.SysUser;

@Local
public interface SysUserService {

	public Collection<SysUser> getUsers();

	public String addUser(SysUser user);

	public String verifyUser(SysUser user);

	public Collection<SysUser> getUsersBy(String viewBy);

	public String changeUsername(String id, String variable);

	public String deleteUser(String id);

	public String changeUserType(String id, String variable);

	public String changeUserPassword(String id, String variable);

}
