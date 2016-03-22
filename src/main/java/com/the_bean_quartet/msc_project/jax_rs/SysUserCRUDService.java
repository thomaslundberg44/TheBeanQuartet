package com.the_bean_quartet.msc_project.jax_rs;



import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.the_bean_quartet.msc_project.entities.Options;
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
		SysUserList users = new SysUserList();
		users.setSysUserCollection(service.getUsers());
        return users;
    }
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public String update(Options option){

		String id = option.getOption1();
		String task = option.getOption2();
		String variable = option.getOption3();
		
		String rule = "";
		
		if(task.equals("name")){
			rule=verifyUsernameRule(variable);
			if(!rule.equals("valid")){
				return rule;
			}
			return service.changeUsername(id, variable);
		}
		if(task.equals("password")){
			rule=verifyPasswordRule(variable);
			if(!rule.equals("valid")){
				return rule;
			}
			return service.changeUserPassword(id, variable);
		}
		if(task.equals("type")){
			return service.changeUserType(id, variable);
		}
		if(task.equals("delete")){
			return service.deleteUser(id);
		}
		
		
        return "updated";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(SysUser user){	
		
		String username = user.getUserName();
		String userpassword = user.getUserPassword();
		String rule="";
		
		
		rule=verifyUsernameRule(username);
		if(!rule.equals("valid")){
			return rule;
		}
		rule=verifyPasswordRule(userpassword);
		if(!rule.equals("valid")){
			System.out.println("failed pws");
			return rule;
		}
		
		
		return service.addUser(user);
	}
	private String verifyUsernameRule(String name){
		if(name.isEmpty()){
			return "No username entered";
		}
		if(containSpecialCharacter(name)){
			return "Special Characters not allowed";
		}
		if(name.length()<4){
			return "Username must be greater than 3 characters";
		}
		if(Character.isDigit(name.charAt(0))){
			return "Username must not start with a number";
		}
		return "valid";
	}

	private boolean containSpecialCharacter(String name) {
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher(name);

		boolean b = m.find();
		if (b == true)
			return true;
		else
			return false;
	}
	private String verifyPasswordRule(String pwd){
		if(pwd.isEmpty()){
			return "No username entered";
		}
		if(containSpecialCharacter(pwd)){
			return "Special Characters not allowed";
		}
		if(pwd.length()<4){
			return "Password must be greater than 3 characters";
		}
		return "valid";
	}
	
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/verify")
	public String verifyUser(SysUser user){
		return service.verifyUser(user);
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
