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
import com.the_bean_quartet.msc_project.entities.SysUser;
import com.the_bean_quartet.msc_project.entities.SysUserList;
import com.the_bean_quartet.msc_project.services.SysUserService;

@Path("/user")
public class SysUserCRUDService {
	
	
	@Inject
	private SysUserService service;
	
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public SysUserList getUsers(){
	//	Runtime.getRuntime().exec("cmd /c start http://www.google.com"); 
		System.out.println("GET Request");
		SysUserList users = new SysUserList();
		users.setSysUserCollection(service.getUsers());
        return users;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(SysUser user2){		
		System.out.println("GET Request");
		service.addUser(user2);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/verify")
	public boolean verifyUser(SysUser user){
		System.out.println("verifyUser()");
		boolean success = service.verifyUser(user);
		System.out.println("success");
		return success;
	}
	public boolean success(SysUser user){
		boolean test = false;
		test = service.verifyUser(user);
		System.out.println(test);
		return test;
	}
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/viewby")
    public SysUserList getUsersBy(String viewBy) throws JsonParseException, JsonMappingException, IOException{
		System.out.println(viewBy);
		ObjectMapper mp = new ObjectMapper();
		String viewByy = mp.readValue(viewBy, String.class);
		System.out.println(viewByy);
		SysUserList users = new SysUserList();
		users.setSysUserCollection(service.getUsersBy(viewByy));
        return users;
    }
    */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/viewby")
	public SysUserList getUsersBy(String viewBy) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mp = new ObjectMapper();
		String viewByy = mp.readValue(viewBy, String.class);
		System.out.println(viewByy);
		SysUserList users = new SysUserList();
		users.setSysUserCollection(service.getUsersBy(viewByy));
        return users;
	}



	
	
	
	
	
	
	
	
	//	ObjectMapper objectMapper = new ObjectMapper();
	//	SysUser user1 = objectMapper.readValue(test, SysUser.class);
	
}
