package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.UserData;
import com.the_bean_quartet.msc_project.entities.UserDataList;
import com.the_bean_quartet.msc_project.services.UserDataService;


@Path("/userdata")
public class UserDataCRUDService {
	
	@Inject
	private UserDataService userService;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserDataList getBaseData() {
        UserDataList data = new UserDataList();
        data.setUserData(userService.getUserDataset());
        return data;
    }
  
//	@GET
//	@Path("/{id}")
// 	@Produces(MediaType.APPLICATION_JSON)
// 	public UserDataList getBaseData1(@PathParam("id") int id) {
//		UserDataList data = new UserDataList();
//        data.setUserData(userService.getUserDataset());
//        return data;
//		return library.get(id);
//	}
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void addBaseData(UserData data) {
//		data.setId(0); // make sure the ID is not set
//		userService.addToUserDataset(data);	}

}
