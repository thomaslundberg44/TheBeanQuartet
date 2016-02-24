package dao_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.the_bean_quartet.msc_project.dao.jpa.JPAFailureClassDAO;
import com.the_bean_quartet.msc_project.entities.FailureClass;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.services.FailureDataServiceEJB;



public class FailureDataServiceEJBTest {
	
	
	private FailureDataServiceEJB failureEJB;

	
	@Before
	public void setup(){
		ArrayList<FailureClass> mockedEvents = new ArrayList<FailureClass>();
		mockedEvents.add(new FailureClass(1,"1"));
		JPAFailureClassDAO MockedDAO = mock(JPAFailureClassDAO.class);
		when((MockedDAO.getAllFailures())).thenReturn(mockedEvents);
		failureEJB = new FailureDataServiceEJB();
		failureEJB.setFailuresDAO(MockedDAO);
		
		
	}
	@Test
	public void test() {
		ArrayList<FailureClass> results = (ArrayList<FailureClass>) failureEJB.getFailureDataset();
		FailureClass resultEvent = results.get(0);
		assertTrue(results.size() == 1);
		assertEquals(resultEvent.getFailureClass().intValue(), 1);
		assertEquals(resultEvent.getDescription(), "1");
		
	}

}
