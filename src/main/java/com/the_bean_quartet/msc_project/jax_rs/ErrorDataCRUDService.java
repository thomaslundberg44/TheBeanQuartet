package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.ErrorData;
import com.the_bean_quartet.msc_project.entities.ErrorDataList;
import com.the_bean_quartet.msc_project.services.ErrorDataService;

@Path("/errordata")
public class ErrorDataCRUDService {

	@Inject
	private ErrorDataService service;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public ErrorDataList getBaseData() {
        ErrorDataList data = new ErrorDataList();
        data.setErrorDataCollection(service.getErrorData());
        return data;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addErrorData(ErrorData data) {
		data.setId(0); // make sure the ID is not set
		service.addToErrorData(data);
	}
	
}
