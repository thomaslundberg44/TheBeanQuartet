package entity_testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.BaseDataList;
import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.FailureClass;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.entities.UETypeClass;

public class TestBaseDataList {

	@Test
	public void testGetBaseDataCollection() {
		BaseData data = new BaseData();
		
		EventCause eventCause=new EventCause(1,1,"description");
		MccData mccData=new MccData(2,2,"country","operator");
		FailureClass failureClass=new FailureClass(1,"description");
		UETypeClass ueTypeClass=new UETypeClass(1,"1","2","3","4","5","6","7","8");
		
		data.setId(1234);
		data.setFailureClass(failureClass);
		data.setMccData(mccData);
		data.setDate("23/2/16 16:43");
		data.setDuration(1000);
		data.setHeir3Id(111111111111111111L);
		data.setHeir32Id(11111111111111111L);
		data.setHeir321Id(2222222222222222L);
		data.setNeVersion("version");
		data.setCellId(54321);
		data.setEventCause(eventCause);
		data.setUeTable(ueTypeClass);
		
		Collection<BaseData> dataList = new ArrayList<BaseData>();
		
		BaseDataList list = new BaseDataList();
		list.setBaseDataCollection(dataList);
		assertEquals(dataList, list.getBaseDataCollection());

		list.setBaseDataCollection(dataList);
		assertEquals(dataList, list.getBaseDataCollection());
		
	}

}
