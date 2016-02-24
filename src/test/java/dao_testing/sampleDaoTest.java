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
//import com.the_bean_quartet.msc_project.dao.jpa.JPAMccDataDAO;
//import com.the_bean_quartet.msc_project.entities.MccData;
//import com.the_bean_quartet.msc_project.services.MccDataServiceEJB;
//
//public class sampleDaoTest {
//
//	private MccDataServiceEJB mccEJB;
//
////	addMockedDAO.addData(new MccData(1,2,"1","2"));
//	
//	@Before
//	public void setup(){
//		ArrayList<MccData> addmockedEvents = new ArrayList<MccData>();
//		addmockedEvents.add(new MccData(1,2,"1","2"));
//		JPAMccDataDAO addMockedDAO = mock(JPAMccDataDAO.class);
//		when((addMockedDAO.getAllMccData())).thenReturn(addmockedEvents);
//		mccEJB = new MccDataServiceEJB();
//		mccEJB.setDao(addMockedDAO);
//		
//	}
//	
//	@Test
//	public void test() {
//		ArrayList<MccData> results = (ArrayList<MccData>) mccEJB.getDataset();
//		MccData resultEvent = results.get(0);
//		assertTrue(results.size() == 1);
//		assertEquals(resultEvent.getMcc(), 1);
//		assertEquals(resultEvent.getMnc(), 2);
//		assertEquals(resultEvent.getCountry(), "1");
//		assertEquals(resultEvent.getOperator(), "2");
//		
//
//	}
//}
