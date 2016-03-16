package dao_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.the_bean_quartet.msc_project.dao.jpa.JPABaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.EventCauseId;
import com.the_bean_quartet.msc_project.entities.FailureClass;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.entities.MccDataId;
import com.the_bean_quartet.msc_project.entities.UETypeClass;
import com.the_bean_quartet.msc_project.services.BaseDataServiceEJB;


public class BaseDataServiceEJBTest {

	private BaseDataServiceEJB baseDataEJB;
	private BaseDataServiceEJB baseDataEJB1;
	
	@Before
	public void setup(){
		ArrayList<BaseData> mockedEvents = new ArrayList<BaseData>();
		EventCause eventCause = new EventCause();
		EventCauseId eventCauseId = new EventCauseId();
		eventCauseId.setEventId(4099);
		eventCauseId.setCauseCode(0);
		eventCause.setId(eventCauseId);
		FailureClass failureClass = new FailureClass(0,"Failure Description");
		MccData mccData = new MccData();
		MccDataId mccId = new MccDataId();
		mccId.setMcc(344);
		mccId.setMnc(930);
		mccData.setId(mccId);
		UETypeClass ueType = new UETypeClass();
		ueType.setModel("phone model");
		ueType.setTac(11112222);
		mockedEvents.add(new BaseData("2013/01/11 17:31",failureClass,mccData,5,6,"2",0L, 
												1L, 2L, 3L, eventCause, ueType));
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
	
		assertEquals("2013/01/11 17:31",resultEvent.getDate());
		EventCauseId eventCauseId = new EventCauseId();
		eventCauseId.setEventId(4099);
		eventCauseId.setCauseCode(0);
		assertEquals(eventCauseId,resultEvent.getEventCause().getId());
		assertEquals(0,(int)resultEvent.getFailureClass().getFailureClass());
		assertEquals("phone model",resultEvent.getUeTable().getModel());
		MccDataId mccId = new MccDataId();
		mccId.setMcc(344);
		mccId.setMnc(930);
		assertEquals(mccId,resultEvent.getMccData().getId());
		assertEquals(5,resultEvent.getUeTable().getModel());
//		assertEquals(6,resultEvent.getCellId().intValue());
//		assertEquals(7,resultEvent.getDuration().intValue());
//		assertEquals(8,resultEvent.getCauseCode().intValue());
		assertEquals("2",resultEvent.getNeVersion());
		assertEquals(0L,resultEvent.getImsi().longValue());
		assertEquals(1L,resultEvent.getHeir3Id().longValue());
		assertEquals(2L,resultEvent.getHeir32Id().longValue());
		assertEquals(3L,resultEvent.getHeir321Id().longValue());
		
		
	}
}
