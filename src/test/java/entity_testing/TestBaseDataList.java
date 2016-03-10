//package entity_testing;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//
//import org.junit.Test;
//
//import com.the_bean_quartet.msc_project.entities.BaseData;
//import com.the_bean_quartet.msc_project.entities.BaseDataList;
//
//public class TestBaseDataList {
//
//	@Test
//	public void testGetBaseDataCollection() {
//		BaseData data = new BaseData();
//		data.setId(1234);
//		data.setCauseCode(4321);
//		data.setDate(new Date());
//		data.setDuration(1000);
//		data.setEventId(1234);
//		data.setFailureClass(0);
//		data.setHeir3Id(111111111111111111L);
//		data.setHeir32Id(11111111111111111L);
//		data.setHeir321Id(2222222222222222L);
//		data.setOperator(341);
//		data.setUeType(400);
//		data.setImsi(43143124312l);
//		data.setMarket(05);
//		data.setNeVersion("version");
//		data.setCellId(54321);
//		
//		Collection<BaseData> dataList = new ArrayList<BaseData>();
//		
//		BaseDataList list = new BaseDataList();
//		list.setBaseDataCollection(dataList);
//		
//		assertEquals(dataList, list.getBaseDataCollection());
//		
//	}
//
//}
