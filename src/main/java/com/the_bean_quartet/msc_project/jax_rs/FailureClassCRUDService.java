package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.FailureDataList;
import com.the_bean_quartet.msc_project.services.FailureDataService;

@Path("/failures")
public class FailureClassCRUDService {

	@Inject
	private FailureDataService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public FailureDataList getFailureData() {
		FailureDataList failures = new FailureDataList();
		failures.setFailureDataCollection(service.getFailureDataset());
		return failures;
	}

}
