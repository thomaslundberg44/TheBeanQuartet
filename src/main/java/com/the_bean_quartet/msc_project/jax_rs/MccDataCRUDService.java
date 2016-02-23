package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.BaseDataList;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.entities.MccDataList;
import com.the_bean_quartet.msc_project.services.BaseDataService;
import com.the_bean_quartet.msc_project.services.MccDataService;

@Path("/mccdata")
public class MccDataCRUDService {

	@Inject
	private MccDataService service;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public MccDataList getMccData() {
        MccDataList data = new MccDataList();
        data.setMccDataCollection(service.getDataset());
        return data;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addMccData(MccData data) {
//		data.setId(0); // make sure the ID is not set
//		service.addToDataset(data);
	}
	
}
