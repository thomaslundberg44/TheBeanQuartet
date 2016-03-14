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
import com.the_bean_quartet.msc_project.entities.SysUserList;
import com.the_bean_quartet.msc_project.services.BaseDataService;

@Path("/basedata")
public class BaseDataCRUDService {

	@Inject
	private BaseDataService service;
	
	@Path("/full")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseDataList getBaseData() {
        BaseDataList data = new BaseDataList();
        data.setBaseDataCollection(service.getDataset());
        return data;
    }
	
	@Path("/imsi")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseDataList getIMSIBaseData() {
        BaseDataList dataIMSI = new BaseDataList();
        dataIMSI.setBaseDataCollection(service.getIMSIData());
        
        return dataIMSI;
    }
	
//	@Path("/imsirelation")
//	@GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public BaseDataList getIMSIRelatedBaseData() {
//        BaseDataList allDataIMSI = new BaseDataList();
//        allDataIMSI.setBaseDataIMSICollection(service.getSelectedBaseData());
//        return allDataIMSI;
//    }

		
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
