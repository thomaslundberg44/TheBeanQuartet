package dao_testing;
//package dao_testing;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.stubbing.OngoingStubbing;
//
//import com.the_bean_quartet.msc_project.dao.jpa.JPAMccDataDAO;
//import com.the_bean_quartet.msc_project.entities.MccData;
//import com.the_bean_quartet.msc_project.services.EventCauseServiceEJB;
//import com.the_bean_quartet.msc_project.services.MccDataServiceEJB;
//
//public class DAOTests {
//	
//	private EventCauseServiceEJB eventEJB;
//	private MccDataServiceEJB mccEJB;
//	
//	@Before
//	public void setup(){
//		ArrayList<MccData> mockedEvents = new ArrayList<MccData>();
//		mockedEvents.add(new MccData(1,2,"1","2"));
//		JPAMccDataDAO mockedDAO = mock(JPAMccDataDAO.class);
//		when(((OngoingStubbing<Object>) mockedDAO.getAllMccData()).thenReturn(mockedEvents));
//		
//		mccEJB = new MccDataServiceEJB();
//		mccEJB.setDao(mockedDAO);
//		
//	}
//	
//	@Test
//	public void test() {
//		ArrayList<MccData> results = (ArrayList<MccData>) mccEJB.getDataset();
//		MccData resultEvent = results.get(0);
//		//assertTrue(results.size() == 1);
//		//assertEquals(resultEvent.getId(), 1);
//		assertEquals(resultEvent.getMcc(), 1);
////		assertEquals(resultEvent.getEventId(), 1);
////		assertEquals(resultEvent.getFailureClass(), 1);
//
//	}
//	
////	@Before
////	public void setup(){
////		ArrayList<Event> mockedEvents = new ArrayList<Event>();
//////		mockedEvents.add(new Event("Todays date", 1, 1, 1, 1, 1, 1, 1, 1, "neVersion", "imsi", "hier3id", "hier32id",
//////				"hier321id"));
////		JPABaseDataDAO mockedDAO = mock(JPABaseDataDAO.class);
////		when(mockedDAO.getAllData().thenReturn(mockedEvents);
////		
////		eventEJB = new EventCauseServiceEJB();
////		eventEJB.setDao(mockedDAO);
////		
////	}
////	@Test
////	public void test() {
////		ArrayList<Event> results = (ArrayList<Event>) eventEJB.getEventByIMSI("Apples");
////		Event resultEvent = results.get(0);
////		assertTrue(results.size() == 1);
////		//assertEquals(resultEvent.getId(), 1);
////		assertEquals(resultEvent.getDate(), "Todays date");
////		assertEquals(resultEvent.getEventId(), 1);
////		assertEquals(resultEvent.getFailureClass(), 1);
////		assertEquals(resultEvent.getTac(), 1);
////		assertEquals(resultEvent.getMnc(), 1);
////		assertEquals(resultEvent.getMcc(), 1);
////		assertEquals(resultEvent.getCellId(), 1);
////		assertEquals(resultEvent.getDuration(), 1);
////		assertEquals(resultEvent.getCauseCode(), 1);
////		assertEquals(resultEvent.getNeVersion(), "neVersion");
////		assertEquals(resultEvent.getImsi(), "imsi");
////		assertEquals(resultEvent.getHier3id(), "hier3id");
////		assertEquals(resultEvent.getHier32id(), "hier32id");
////		assertEquals(resultEvent.getHier321id(), "hier321id");
////	}
//}
