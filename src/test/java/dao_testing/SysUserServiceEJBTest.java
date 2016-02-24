package dao__EJB_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import com.the_bean_quartet.msc_project.dao.jpa.JPASysUserDAO;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.entities.SysUser;
import com.the_bean_quartet.msc_project.services.SysUserServiceEJB;

public class SysUserServiceEJBTest {

	private SysUserServiceEJB sysEJB;
	
	@Before
	public void setup(){
		ArrayList<SysUser> mockedEvents = new ArrayList<SysUser>();
		mockedEvents.add(new SysUser("1","2","3"));
		JPASysUserDAO MockedDAO = mock(JPASysUserDAO.class);
		when((MockedDAO.getAllUsers())).thenReturn(mockedEvents);
		sysEJB = new SysUserServiceEJB();
		sysEJB.setDao(MockedDAO);
		
	}
	
	@Test
	public void test() {
		ArrayList<SysUser> results = (ArrayList<SysUser>) sysEJB.getUsers();
		SysUser resultEvent = results.get(0);
		assertTrue(results.size() == 1);
		assertEquals(resultEvent.getUserName(), "1");
		assertEquals(resultEvent.getUserPassword(), "2");
		assertEquals(resultEvent.getUserType(), "3");
	
	}
}
