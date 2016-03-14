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
import com.the_bean_quartet.msc_project.entities.Options;
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
	}	
	
	@Path("/modelType")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseDataList getModelBaseData() {
        BaseDataList dataModel = new BaseDataList();
        dataModel.setBaseDataModelCollection(service.getModelData());
        return dataModel;
    }
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	//@Path("/modelSearch")
//	public BaseDataList getIMSIRelatedBaseData(String model) throws JsonParseException, JsonMappingException, IOException{
//		ObjectMapper mp = new ObjectMapper();
//		String modelValue = mp.readValue(model, String.class);
//		System.out.println(modelValue);
//		BaseDataList allDataIMSI = new BaseDataList();
//		allDataIMSI.setBaseDataModelCollection(service.getSelectedModelBaseData(modelValue));
//      	return allDataIMSI;
//        
//	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/modelSearch")
	public BaseDataList getModelRelatedBaseData(Options obj) throws JsonParseException, JsonMappingException, IOException{
	
	//	ObjectMapper mp = new ObjectMapper();
	//	String modelValue = mp.readValue(obj.getOption1(), O.class);
		System.out.println(obj.getOption1());
		System.out.println(obj.getOption2());
		System.out.println(obj.getOption3());
		
		//String modelValue1 = mp.readValue(obj.getOption2(), String.class);
	//	System.out.println(modelValue1);

		//String modelValue2 = mp.readValue(obj.getOption3(), String.class);
		//System.out.println(modelValue2);
		
		String modelValue1 = obj.getOption1().toString();
		String modelValue2 = obj.getOption2().toString();
		String modelValue3 = obj.getOption3().toString();
		BaseDataList allDataModel = new BaseDataList();
		allDataModel.setBaseDataModelCollection(service.getSelectedModelBaseData(modelValue1,modelValue2,modelValue3));
      	return allDataModel;
        
	}
	@Path("/imsi")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseDataList getIMSIBaseData() {
        BaseDataList dataIMSI = new BaseDataList();
        dataIMSI.setBaseDataCollection(service.getIMSIData());
        
        return dataIMSI;
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/imsirelation")
	public BaseDataList getIMSIRelatedBaseData(String imsiVal) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mp = new ObjectMapper();
		String imsiValue = mp.readValue(imsiVal, String.class);
		System.out.println(imsiValue);
		BaseDataList allDataIMSI = new BaseDataList();
		allDataIMSI.setBaseDataCollection(service.getSelectedBaseData(imsiValue));
      	return allDataIMSI;
        
	}
	
}
