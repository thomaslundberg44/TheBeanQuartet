package dao_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.the_bean_quartet.msc_project.dao.jpa.JPAUserDataDAO;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.entities.UserData;
import com.the_bean_quartet.msc_project.services.UserDataServiceEJB;



public class UserDataServiceEJBTest {

	private UserDataServiceEJB userEJB;
	
	@Before
	public void setup(){
		ArrayList<UserData> mockedEvents = new ArrayList<UserData>();
		mockedEvents.add(new UserData(1,"1","2","3"));
		JPAUserDataDAO mockedDAO = mock(JPAUserDataDAO.class);
		when((mockedDAO.getAllUserData())).thenReturn(mockedEvents);
		
		userEJB = new UserDataServiceEJB();
		userEJB.setDao(mockedDAO);
		
	}
	
	@Test
	public void test() {
		ArrayList<UserData> results = (ArrayList<UserData>) userEJB.getUserDataset();
		UserData resultEvent = results.get(0);
		assertTrue(results.size() == 1);
	
		assertEquals(1,resultEvent.getId());
		assertEquals("1",resultEvent.getUserName());
		assertEquals("2",resultEvent.getUserPassword());
		assertEquals("3",resultEvent.getUserType());	
		
	}
}
