package services_testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.the_bean_quartet.msc_project.dao.jpa.JPABaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.FailureClass;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.entities.UETypeClass;
import com.the_bean_quartet.msc_project.services.BaseDataServiceEJB;

public class BaseDataServiceTest {


	private BaseDataServiceEJB baseDataEJB;
	private BaseDataServiceEJB baseDataEJB1;
	private ArrayList<BaseData> mockedEvents;
	private BaseData baseData1, baseData2;
	private Collection<BaseData> bds;
	
	@Before
	public void setup(){
		mockedEvents= new ArrayList<BaseData>();
		baseData1 = new BaseData("1",new FailureClass(1,"1"),new MccData(1,2,"1","2"),3,4,"5","6",7L,8L,2L,new EventCause(1,1,"a"),new UETypeClass(1,"1","2","3","4","5","6","7","8"));
		baseData2 = new BaseData("1",new FailureClass(1,"1"),new MccData(1,2,"1","2"),3,4,"5","6",7L,8L,2L,new EventCause(1,1,"a"),new UETypeClass(1,"1","2","3","4","5","6","7","8"));
		//bds = new ArrayList<BaseData>();
		mockedEvents.add(baseData1);
		mockedEvents.add(baseData2);
		//mockedEvents.add(new BaseData("1",new FailureClass(1,"1"),new MccData(1,2,"1","2"),3,4,"5","6",7L,8L,2L,new EventCause(1,1,"a"),new UETypeClass(1,"1","2","3","4","5","6","7","8")));
		JPABaseDataDAO mockedDAOALl = mock(JPABaseDataDAO.class);
		when((mockedDAOALl.getAllData())).thenReturn(mockedEvents);
		when((mockedDAOALl.getAllIMSIData())).thenReturn(mockedEvents);
		when((mockedDAOALl.getAllIMSIRelatedData("1"))).thenReturn(mockedEvents);
		baseDataEJB = new BaseDataServiceEJB();
		baseDataEJB.setDao(mockedDAOALl);
		
	}
	@Test
	public void getTest(){
		
		Collection<BaseData> baseData= baseDataEJB.getIMSIData();
		Collection<BaseData> baseData11= baseDataEJB.getSelectedBaseData("1");
		Collection<BaseData> baseData12= baseDataEJB.getIMSIData();
		assertEquals(baseData1,baseData.iterator().next());
		assertEquals(baseData1,baseData11.iterator().next());
		assertEquals(baseData1,baseData12.iterator().next());
	}
}
