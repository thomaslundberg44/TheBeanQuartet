package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.BaseDataList;
import com.the_bean_quartet.msc_project.services.BaseDataService;

@Path("/basedata")
public class BaseDataCRUDService {

	@Inject
	private BaseDataService service;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseDataList getBaseData() {
        BaseDataList data = new BaseDataList();
        data.setBaseDataCollection(service.getDataset());
        return data;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBaseData(BaseData data) {
		data.setId(0); // make sure the ID is not set
		service.addToDataset(data);
	}
	
}
