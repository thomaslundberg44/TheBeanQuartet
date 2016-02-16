package com.the_bean_quartet.msc_project.services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/orders")
//@Interceptors(CallAudit.class)
@Stateless
public class SimpleRest {
	@GET
    @Path("{name}")
    @Produces({"application/xml","application/json", "text/plain"})
    public String sayHello(@PathParam("name") String name){
       return "hello " + name;
    }
}
