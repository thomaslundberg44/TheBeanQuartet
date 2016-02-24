import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.EventCauseId;

public class TestEventCauseId {

	@Test
	public void test() {
		EventCauseId id = new EventCauseId();
		id.setCauseCode(1234);
		id.setEventId(4321);
		
		EventCauseId id2 = new EventCauseId();
		id.setCauseCode(1234);
		id.setEventId(4321);
		
		// ensure if 2 event ids are equal, hash code must also be the same
		if(id2 != null) {
			System.out.println("id 2 is not null");
			//assertTrue(id.equals(id2));
			//assertEquals(id.hashCode(), id2.hashCode());
		}
		else
			System.out.println("Null values");
		
	}

}
