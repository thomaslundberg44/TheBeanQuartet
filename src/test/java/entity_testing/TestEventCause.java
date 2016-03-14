package entity_testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.BaseDataList;
import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.EventCauseId;
import com.the_bean_quartet.msc_project.entities.EventCauseList;

public class TestEventCause {

@Test
	public void testEquals(){
		EventCause eCause=new EventCause(0, 1,"objOne");
		EventCause eCause2=new EventCause(0, 1,"objOne");
		EventCause eCause3=new EventCause(69,1,"objThree");
		EventCause eCause4=new EventCause(1,69,"objFour");
		assertFalse(eCause.equals(null));
		assertTrue(eCause.equals(eCause));
		assertFalse(eCause.equals(new String()));
		assertTrue(eCause.equals(eCause2));
		assertFalse(eCause.equals(eCause3));
		assertFalse(eCause.equals(eCause4));
		
		Collection<EventCause> eventList = new ArrayList<EventCause>();
		
		EventCauseList list = new EventCauseList();
		list.setEventCauseCollection(eventList);
		
		assertEquals(eventList, list.getEventCauseCollection());
		
	}
	
	
@Test
	public void testGetDescription() {
		EventCause event = new EventCause(1234, 4321, "1234");
		
		EventCause event2 = new EventCause();
		EventCauseId id = new EventCauseId();
//		event2.setId(id);
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
