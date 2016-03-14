package dao_testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.services.EventCauseServiceEJB;


public class EventCauseDataServiceEJBTest {
	
	

	@Test
	public void testEquals(){
		
		EventCause EventCauseTest1 = new EventCause(0,0,"description");
		EventCause EventCasueTest2 = new EventCause(1,1,"second description");

		assertFalse(EventCauseTest1.equals(null));

		assertTrue(EventCauseTest1.equals(EventCauseTest1));
		assertFalse(EventCauseTest1.equals(new String()));

		EventCauseTest1.setDescription("wrong desc");
		assertFalse(EventCauseTest1.equals(EventCasueTest2));
		EventCauseTest1.setDescription(null);
		assertFalse(EventCauseTest1.equals(EventCasueTest2));
		
		EventCauseTest1.setEventId(5);
		assertFalse(EventCauseTest1.equals(EventCasueTest2));
		
		EventCauseTest1.setCauseCode(69);
		assertFalse(EventCauseTest1.equals(EventCasueTest2));
		

	}

}
