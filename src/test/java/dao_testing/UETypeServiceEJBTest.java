package dao_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.the_bean_quartet.msc_project.dao.jpa.JPAUETypeClassDAO;
import com.the_bean_quartet.msc_project.entities.UETypeClass;
import com.the_bean_quartet.msc_project.services.UETypeServiceJEJB;



public class UETypeServiceEJBTest {

	private UETypeServiceJEJB ueEJB;

	
	@Before
	public void setup(){
		ArrayList<UETypeClass> mockedEvents = new ArrayList<UETypeClass>();
		mockedEvents.add(new UETypeClass(1,"1","2","3","4","5","6","7","8"));
		JPAUETypeClassDAO MockedDAO = mock(JPAUETypeClassDAO.class);
		when((MockedDAO.getAllUEType())).thenReturn(mockedEvents);
		ueEJB = new UETypeServiceJEJB();
		ueEJB.setUeTypeClassDAO(MockedDAO);
		
	}
	
	@Test
	public void test() {
		ArrayList<UETypeClass> results = (ArrayList<UETypeClass>) ueEJB.getUEDataset();
		UETypeClass resultEvent = results.get(0);
		assertTrue(results.size() == 1);
		assertEquals(resultEvent.getTac().intValue(), 1);
		assertEquals(resultEvent.getMarketingName(), "1");
		assertEquals(resultEvent.getManufacturer(), "2");
		assertEquals(resultEvent.getAccessCapability(), "3");
		assertEquals(resultEvent.getModel(), "4");
		assertEquals(resultEvent.getVendorName(), "5");
		assertEquals(resultEvent.getUeType(), "6");
		assertEquals(resultEvent.getOs(), "7");
		assertEquals(resultEvent.getInputMode(), "8");
		

	}

}
