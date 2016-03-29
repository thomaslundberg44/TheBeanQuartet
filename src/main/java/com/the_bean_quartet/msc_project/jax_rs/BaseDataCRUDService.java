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

		System.out.println(obj.getOption1());
		System.out.println(obj.getOption2());
		System.out.println(obj.getOption3());
		
		String modelValue1 = obj.getOption1().toString();
		String modelValue2 = obj.getOption2().toString();
		String modelValue3 = obj.getOption3().toString();
		BaseDataList allDataModel = new BaseDataList();
		allDataModel.setBaseDataModelCollection(service.getSelectedModelBaseData(obj.getOption1().toString(),obj.getOption2().toString(),obj.getOption3().toString()));
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
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/causeCodeWithCallFailure")
	public BaseDataList getCauseCodeWithCallFailureForAnImsi(String imsi) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mp = new ObjectMapper();
		String imsiValue = mp.readValue(imsi, String.class);
		System.out.println(imsiValue+"111111111111111111111111111111111");
		BaseDataList CauseCodeWithCallFailure = new BaseDataList();
		CauseCodeWithCallFailure.setBaseDataCollection(service.getCauseCodeWithCallFailureForAnImsi(imsiValue));
      	return CauseCodeWithCallFailure;
        
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/imsiFailureCount")
	public BaseDataList getIMSIFailureCount(Options obj) throws JsonParseException, JsonMappingException, IOException{
		String modelValue1=obj.getOption1().toString();
		String modelValue2=obj.getOption2().toString();
		String modelValue3=obj.getOption3().toString();
		
		System.out.println(modelValue1+"  "+modelValue2+"  "+modelValue3);
		
		BaseDataList allDataIMSI = new BaseDataList();
		allDataIMSI.setBaseDataCollection(service.getImsiFailureCount(modelValue1, modelValue2, modelValue3));
		System.out.println(allDataIMSI);
      	return allDataIMSI;
        
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/countEachImsi")
	public BaseDataList getCountEachImsiBaseData(Options obj) throws JsonParseException, JsonMappingException, IOException{
		String modelValue1 = obj.getOption1().toString();
		String modelValue2 = obj.getOption2().toString();
		
		System.out.println(obj.getOption1());
		System.out.println(obj.getOption2());
		
		BaseDataList eachImsiSearch = new BaseDataList();
		eachImsiSearch.setBaseDataEachImsiSearchCollection(service.getEachImsiBaseData(modelValue1, modelValue2));
      	return eachImsiSearch;
        
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/listImsiWithFailureDateRange")
	public BaseDataList getlistImsiWithFailureDateRange(Options obj) throws JsonParseException, JsonMappingException, IOException{
		String modelValue1 = obj.getOption1().toString();
		String modelValue2 = obj.getOption2().toString();
		
		System.out.println(obj.getOption1());
		System.out.println(obj.getOption2());
		
		BaseDataList listImsiWithFailureDateRangeSearch = new BaseDataList();
		listImsiWithFailureDateRangeSearch.setBaseDataListImsiWithFailureCollection(service.
				getListImsiWithFailureTimeRange(modelValue1, modelValue2));
      	return listImsiWithFailureDateRangeSearch;
        
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/top10Imsi")
	public BaseDataList getTopTenImsiBaseData(Options obj) throws JsonParseException, JsonMappingException, IOException{
		String modelValue1 = obj.getOption1().toString();
		String modelValue2 = obj.getOption2().toString();
		
		System.out.println(obj.getOption1());
		System.out.println(obj.getOption2());
		
		BaseDataList eachImsiSearch = new BaseDataList();
		eachImsiSearch.setBaseDataEachImsiSearchCollection(service.getTop10ImsiBaseData(modelValue1, modelValue2));
      	return eachImsiSearch;
        
	}
	
	@Path("/failureCauseClass")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseDataList getAllFailureCauseClass() {
        BaseDataList failureCauseClass = new BaseDataList();
        failureCauseClass.setBaseDataCollection(service.getAllFailureCauseClass());
        return failureCauseClass;
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ImsiForAnFailureCauseClass")
	public BaseDataList getImsiForAnFailureCauseClass(String failureCauseClass) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mp = new ObjectMapper();
		String failureCauseClassValue = mp.readValue(failureCauseClass, String.class);
		System.out.println(failureCauseClassValue+"111111111111111111111111111111111");

		
		BaseDataList ImsiForAnFailureCauseClass = new BaseDataList();
		ImsiForAnFailureCauseClass.setBaseDataListImsiForAnFailureCauseClass
									(service.getImsiForAnFailureCauseClass(failureCauseClassValue));
      	return ImsiForAnFailureCauseClass;
        
	}
}
