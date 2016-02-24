package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.UEDataList;
import com.the_bean_quartet.msc_project.services.UETypeService;

@Path("/UEData")
public class UEDataCRUDService {

	@Inject
	private UETypeService service;
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UEDataList getUEData() {
		UEDataList UE = new UEDataList();
		UE.setUEDataCollection(service.getUEDataset());
		return UE;
	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void addUEData(UETypeClass ueData) {
//		ueData.setId(0); // make sure the ID is not set
//		service.addToUEDataset(ueData);
//	}
//	
}
