package entity_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.Date;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.FailureClass;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.entities.SysUser;
import com.the_bean_quartet.msc_project.entities.UETypeClass;
import com.the_bean_quartet.msc_project.entities.UserData;

public class entityTesting {


	@Test
	public void testBaseData() {
		BaseData dataConstructor = new BaseData(new Date(),1,2,3,4,5,6,7,8,"2",0L, 
															1L, 2L, 3L);
		BaseData data = new BaseData();
		
		data.setDate(new Date());
		data.setEventId(1);
		data.setFailureClass(2);
		data.setUeType(3);
		data.setMarket(4);
		data.setOperator(5);
		data.setCellId(6);
		data.setDuration(7);
		data.setCauseCode(8);
		data.setNeVersion("2");
		data.setImsi(0L);
		data.setHeir321Id(3L);
		data.setHeir32Id(2L);
		data.setHeir3Id(1L);
		
		assertEquals("1",data.getDate());
		assertEquals(1,data.getEventId().intValue());
		assertEquals(2,data.getFailureClass().intValue());
		assertEquals(3,data.getUeType().intValue());
		assertEquals(4,data.getMarket().intValue());
		assertEquals(5,data.getOperator().intValue());
		assertEquals(6,data.getCellId().intValue());
		assertEquals(7,data.getDuration().intValue());
		assertEquals(8,data.getCauseCode().intValue());
		assertEquals("2",data.getNeVersion());
		assertEquals(0L,data.getImsi().longValue());
		assertEquals(1L,data.getHeir3Id().longValue());
		assertEquals(2L,data.getHeir32Id().longValue());
		assertEquals(3L,data.getHeir321Id().longValue());
	}
	
	
	@Test
	public void testMccData() {
		
		MccData mccDataConstructor = new MccData(1,2,"1","2");	
		MccData mccData = new MccData();
		//MccDataList mccDataList = new MccDataList();
		mccData.setMcc(1);
		mccData.setMnc(2);
		mccData.setCountry("1");
		mccData.setOperator("2");
		assertEquals(1,mccData.getMcc());
		assertEquals(2,mccData.getMnc());
		assertEquals("1",mccData.getCountry());
		assertEquals("2",mccData.getOperator());
		assertNotSame(2,mccData.getMcc());
		assertNotSame("2",mccData.getCountry());
		
	}
	
	@Test
	public void testSysUser() {
		
		SysUser sysUserConstructor = new SysUser("1","2","2");	
		SysUser sysUser = new SysUser();
		//MccDataList mccDataList = new MccDataList();
		sysUser.setUserName("1");
		sysUser.setUserPassword("2");
		sysUser.setUserType("3");

		assertEquals("1",sysUser.getUserName());
		assertEquals("2",sysUser.getUserPassword());
		assertEquals("3",sysUser.getUserType());
		
	}


	
	@Test
	public void testFailure() {
		
		FailureClass failureConstructor = new FailureClass(1,"1");
		FailureClass failure = new FailureClass();
		failure.setFailureClass(1);
		failure.setDescription("1");
		
		assertEquals(1,failure.getFailureClass().intValue());
		assertEquals("1",failure.getDescription());

		assertNotSame(2,failure.getFailureClass().intValue());
		assertNotSame("2",failure.getDescription());
	}
	
	@Test
	public void testUEType() {
		
		UETypeClass ueConstructor = new UETypeClass(1,"1","2","3","4","5","6","7","8");
		UETypeClass ue = new UETypeClass();
		ue.setTac(1);
		ue.setMarketingName("1");
		ue.setManufacturer("2");
		ue.setAccessCapability("3");
		ue.setModel("4");
		ue.setVendorName("5");
		ue.setUeType("6");
		ue.setOs("7");
		ue.setInputMode("8");
		
		assertEquals(1,ue.getTac().intValue());
		assertEquals("1",ue.getMarketingName());
		assertEquals("2",ue.getManufacturer());
		assertEquals("3",ue.getAccessCapability());
		assertEquals("4",ue.getModel());
		assertEquals("5",ue.getVendorName());
		assertEquals("6",ue.getUeType());
		assertEquals("7",ue.getOs());
		assertEquals("8",ue.getInputMode());
		assertNotSame(2,ue.getTac().intValue());
		assertNotSame("1",ue.getInputMode());
	}
	
//	@Test
//	public void testEventCause() {
//		EventCause eventConstructor = new EventCause(1,2,"1");
//		EventCauseId id = new EventCauseId();
//		EventCause event = new EventCause();
//		id.setCauseCode(1);
//		event.setCauseCode((int)(id.setCauseCode(1)));
//		event.setEventId(2);
//		event.setDescription("1");
//		
//		assertEquals(1,event.getCauseCode().intValue());
//		assertEquals(2,event.getEventId().intValue());
//		assertEquals("1",event.getDescription());
//	}

	
	@Test
	public void testUserData() {
		UserData userConstructor = new UserData(1,"1","2","3");
		UserData user = new UserData();
		user.setId(1);	
		user.setUserName("1");
		user.setUserPassword("2");
		user.setUserType("3");
		
		assertEquals(1,user.getId());
		assertEquals("1",user.getUserName());
		assertEquals("2",user.getUserPassword());
		assertEquals("3",user.getUserType());
	}
	

}
