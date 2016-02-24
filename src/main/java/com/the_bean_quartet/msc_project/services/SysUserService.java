package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.Local;

import com.the_bean_quartet.msc_project.entities.SysUser;

@Local
public interface SysUserService {

	public Collection<SysUser> getUsers();

	public void addUser(SysUser user);

	public boolean verifyUser(SysUser user);

	public Collection<SysUser> getUsersBy(String viewBy);

}
