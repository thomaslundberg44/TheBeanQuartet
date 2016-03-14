package dao_testing;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import com.the_bean_quartet.msc_project.dao.jpa.JPAMccDataDAO;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.services.MccDataServiceEJB;

public class MccDataServiceEJBTest {
	

	@Test
	public void testEquals(){
		
		MccData MccDataTest1 = new MccData(0,0,"description","desccription");
		MccData MccDataTest2 = new MccData(1,1,"second description","second description");

		assertFalse(MccDataTest1.equals(null));

		assertTrue(MccDataTest1.equals(MccDataTest1));
		assertFalse(MccDataTest1.equals(new String()));

		MccDataTest1.setOperator("wrong desc");
		assertFalse(MccDataTest1.equals(MccDataTest2));
		MccDataTest1.setOperator(null);
		assertFalse(MccDataTest1.equals(MccDataTest2));
		
		MccDataTest1.setCountry("wrong desc");
		assertFalse(MccDataTest1.equals(MccDataTest2));
		MccDataTest1.setCountry(null);
		assertFalse(MccDataTest1.equals(MccDataTest2));

		MccDataTest1.setMnc(69);
		assertFalse(MccDataTest1.equals(MccDataTest2));
		MccDataTest1.setMcc(69);
		assertFalse(MccDataTest1.equals(MccDataTest2));
		

	}
	
}
