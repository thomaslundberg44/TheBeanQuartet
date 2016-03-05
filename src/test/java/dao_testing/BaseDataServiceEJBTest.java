package dao_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.the_bean_quartet.msc_project.dao.jpa.JPABaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.services.BaseDataServiceEJB;


public class BaseDataServiceEJBTest {

	private BaseDataServiceEJB baseDataEJB;
	private BaseDataServiceEJB baseDataEJB1;
	
	@Before
	public void setup(){
		ArrayList<BaseData> mockedEvents = new ArrayList<BaseData>();
		mockedEvents.add(new BaseData(new Date(),1,2,3,4,5,6,7,8,"2",0L, 
												1L, 2L, 3L));
		JPABaseDataDAO mockedDAOALl = mock(JPABaseDataDAO.class);
		when((mockedDAOALl.getAllData())).thenReturn(mockedEvents);
		baseDataEJB = new BaseDataServiceEJB();
		baseDataEJB.setDao(mockedDAOALl);
		
	}
	
	
	@Test
	public void test() {
		ArrayList<BaseData> results = (ArrayList<BaseData>) baseDataEJB.getDataset();
		BaseData resultEvent = results.get(0);
		assertTrue(results.size() == 1);
	
		assertEquals("1",resultEvent.getDate());
		assertEquals(1,resultEvent.getEventId().intValue());
		assertEquals(2,resultEvent.getFailureClass().intValue());
		assertEquals(3,resultEvent.getUeType().intValue());
		assertEquals(4,resultEvent.getMarket().intValue());
		assertEquals(5,resultEvent.getOperator().intValue());
		assertEquals(6,resultEvent.getCellId().intValue());
		assertEquals(7,resultEvent.getDuration().intValue());
		assertEquals(8,resultEvent.getCauseCode().intValue());
		assertEquals("2",resultEvent.getNeVersion());
		assertEquals(0L,resultEvent.getImsi().longValue());
		assertEquals(1L,resultEvent.getHeir3Id().longValue());
		assertEquals(2L,resultEvent.getHeir32Id().longValue());
		assertEquals(3L,resultEvent.getHeir321Id().longValue());
		
		
	}
}
