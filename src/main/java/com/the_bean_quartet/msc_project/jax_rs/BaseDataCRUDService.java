package com.the_bean_quartet.msc_project.jax_rs;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		System.out.println("adding base data object");
		data.setId(0); // make sure the ID is not set
		service.addToDataset(data);
	}	@Path("/modelType")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseDataList getIMSIBaseData() {
        BaseDataList dataIMSI = new BaseDataList();
        dataIMSI.setBaseDataModelCollection(service.getModelData());
        return dataIMSI;
    }
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/modelSearch")
	public BaseDataList getIMSIRelatedBaseData(String model) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mp = new ObjectMapper();
		String modelValue = mp.readValue(model, String.class);
		System.out.println(modelValue);
		BaseDataList allDataIMSI = new BaseDataList();
		allDataIMSI.setBaseDataModelCollection(service.getSelectedModelBaseData(modelValue));
      	return allDataIMSI;
        
	}
	
}
