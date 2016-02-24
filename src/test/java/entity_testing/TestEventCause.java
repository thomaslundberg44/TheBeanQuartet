package entity_testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.EventCauseId;

public class TestEventCause {

	@Test
	public void testGetId() {
		EventCause event = new EventCause();
		EventCauseId eventId = new EventCauseId();
		eventId.setEventId(1234);
		eventId.setCauseCode(4321);
		event.setId(eventId);
		
		EventCauseId newEventId = event.getId();
		
		assertEquals(eventId, newEventId);
	}

	@Test
	public void testGetDescription() {
		EventCause event = new EventCause(1234, 4321, "1234");
		
		EventCause event2 = new EventCause();
		EventCauseId id = new EventCauseId();
		event2.setId(id);
		event2.setDescription("New event");

		assertEquals("1234", event.getDescription());
		
		assertFalse(event2.equals(event));
		
		EventCauseId id2 = new EventCauseId();
		id2.setEventId(1234);
		id2.setCauseCode(4321);
		
		id.setEventId(1234);
		id.setCauseCode(4321);
		
		// test if equals is true, hashCode must also equal
		assertTrue(id.equals(id2));
		assertEquals(id.hashCode(), id2.hashCode());
		
		// test that event cause does not equal event cause id
		assertFalse(id.equals(event));
		
		id2.setCauseCode(1234);
		assertFalse(id.equals(id2));
		
		id2.setCauseCode(4321);
		id2.setEventId(4321);
		assertFalse(id.equals(id2));
		
	}

}
