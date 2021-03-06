package com.the_bean_quartet.msc_project.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.the_bean_quartet.msc_project.dao.SysUserDAO;
import com.the_bean_quartet.msc_project.entities.SysUser;







@Stateless
@Local
public class JPASysUserDAO implements SysUserDAO{
	
	
	
	@PersistenceContext
	private EntityManager em;
	private EntityTransaction tx;
	

	
	public String addUser(SysUser user) {
		if(userExist(user)){
			return "Username already Exists";
		}
		em.persist(user);
		return "User Added Successfully";
	}
	
	public void deleteAllEntries() {
		Query query = em.createQuery("DELETE from SysUser");
		query.executeUpdate();
	}
	
	public boolean userExist(SysUser user){
		Query query = em.createQuery("from SysUser");
		List<SysUser> users = query.getResultList();
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUserName().equals(user.getUserName())){
				return true;
			}
		}
		return false;
	}

	

	public Collection<SysUser> getAllUsers() {
		Query query = em.createQuery("from SysUser");
		List<SysUser> users = query.getResultList(); 
		return users;
		
	}
	public String verify_user(SysUser user) {
		Query query = em.createQuery("from SysUser");
		List<SysUser> users = query.getResultList(); 
		for(int i=0; i<users.size(); i++){
			if(users.get(i).getUserName().equals(user.getUserName())){
				if(users.get(i).getUserPassword().equals(user.getUserPassword())){
					return users.get(i).getUserType();
				}
			}
		}
		return "false";
	}
	public Collection<SysUser> getAllUsersBy(String UserType) {
		Query query  = em.createQuery("from SysUser su where su.UserType = :UserType");
		query.setParameter("UserType", UserType);
		List<SysUser> users = query.getResultList(); 
		return users;
	}


	public String changeUsername(String User_Id, String UserName) {
		int id = Integer.parseInt(User_Id);
		SysUser user = em.find(SysUser.class, id);
		user.setUserName(UserName);
		em.merge(user);
		return "Username has been modified!";
	}
	public String changeUserPassword(String User_Id, String password) {
		int id = Integer.parseInt(User_Id);
		SysUser user = em.find(SysUser.class, id);
		user.setUserPassword(password);
		em.merge(user);
		return "User Password has been modified!";
	}
	public String changeUserType(String User_Id, String type) {
		int id = Integer.parseInt(User_Id);
		SysUser user = em.find(SysUser.class, id);
		user.setUserType(type);
		em.merge(user);
		return "User Type has been modified!";
	}
	public String deleteUser(String User_Id) {
		int id = Integer.parseInt(User_Id);
		SysUser user = em.find(SysUser.class, id);
		em.remove(user);
		return "User has been deleted!";
	}


}
