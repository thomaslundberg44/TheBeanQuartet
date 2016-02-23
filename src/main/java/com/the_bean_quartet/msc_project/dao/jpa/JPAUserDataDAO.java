package com.the_bean_quartet.msc_project.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.the_bean_quartet.msc_project.dao.UserDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.UserData;


@Stateless
@Local
public class JPAUserDataDAO implements UserDataDAO{

	@PersistenceContext
	private EntityManager em;
	
	public void addData(UserData uData) {
		
		Query query = em.createQuery("from BaseData");
		List<BaseData> data = query.getResultList(); 
		if (!data.contains(uData))
			em.persist(uData);	
		
	}

	public Collection<UserData> getAllUserData() {
		Query query = em.createQuery("from UserData");
		List<UserData> userData = query.getResultList(); 
		return userData;
		
	}

}
