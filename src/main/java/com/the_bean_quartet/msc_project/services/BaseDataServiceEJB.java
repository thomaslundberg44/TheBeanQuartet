package com.the_bean_quartet.msc_project.services;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.the_bean_quartet.msc_project.dao.BaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;


	@Stateless
	@Local
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public class BaseDataServiceEJB  implements BaseDataService {
		
			
		@EJB // uses reflection
		private BaseDataDAO dao;
		
//		@Resource
//		private SessionContext context;

		public void setDao(BaseDataDAO dao) {
			// do something really important on injection
			this.dao = dao;
		}

		
		public void addToDataset(BaseData bData) {
			
				dao.addData(bData);
			
		}
		
		public Collection<BaseData> getDataset() {
			return dao.getAllData();
		}

	}

