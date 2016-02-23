package com.the_bean_quartet.msc_project.jax_rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.EventCauseList;
import com.the_bean_quartet.msc_project.services.EventCauseService;

@Path("/eventCause")
public class EventCauseCRUDService {
	
	@Inject
	private EventCauseService service;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public EventCauseList getEventData() {
        EventCauseList events = new EventCauseList();
        events.setEventCauseCollection(service.getEventCauseDataset());
        return events;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBaseData(EventCause event) {
		//event.setId(0); // make sure the ID is not set
		service.addToEventCauseDataset(event);
	}

}
