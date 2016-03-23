package arquillian_testing;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.the_bean_quartet.msc_project.entities.*;
import com.the_bean_quartet.msc_project.services.BaseDataService;
import com.the_bean_quartet.msc_project.services.BaseDataServiceEJB;
import com.the_bean_quartet.msc_project.dao.*;
import com.the_bean_quartet.msc_project.dao.jpa.*;



@RunWith(Arquillian.class)
public class TestEventPersistence {
	
	@EJB
	BaseDataService baseDataService;

	@Inject
	EventCauseDAO eventDAO;
	
	@Inject
	FailureClassDAO failureClassDAO;
	
	@Inject
	BaseDataDAO baseDataDAO;
	
	@Inject
	MccMncDataDAO mccMncDataDAO;
	
	@Inject
	SysUserDAO sysUserDAO;
	
	@Inject
	UserDataDAO userDataDAO;
		
	@Inject
	UETypeClassDAO ueTypeDAO;

	@Deployment
	public static JavaArchive createDeployment() {
	    return ShrinkWrap.create(JavaArchive.class, "test.jar")
	        .addPackage(BaseDataServiceEJB.class.getPackage())
	        .addPackage(BaseData.class.getPackage())
	        .addPackage(JPABaseDataDAO.class.getPackage())
	        .addPackage(BaseDataDAO.class.getPackage())
	        .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
	        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	  }


	@Test @InSequence(1)
	public void loadAllTablesData(){

		UETypeClass ueType = new UETypeClass(100100,"G410","Mitsubishi","GSM 1800", "GSM 900","G410","null","null","null");
		ueTypeDAO.addUE(ueType);
		
		EventCause eventCause = new EventCause(1,4097,"RRC CONN SETUP-SUCCESS");
		eventDAO.addEvents(eventCause);
		
		FailureClass failureClass = new FailureClass (1,"EMERGENCY");
		failureClassDAO.addFailures(failureClass);
		
		MccData mcc = new MccData(238,1,"Denmark","TDC-DK");
		mccMncDataDAO.addData(mcc);
		
		SysUser sysData = new SysUser("navi","123","developer");
		sysUserDAO.addUser(sysData);
		
	}
	

	@Test @InSequence(2)
	public void baseDataTableTesting() throws ParseException, IOException {
		List<BaseData> baseData = (List<BaseData>) baseDataDAO.getAllData();
		assertEquals(baseData.size(),0);

	}
	
	@Test @InSequence (3)
	public void failureClassTableTesting(){
		
		List<FailureClass> failureClass = (List<FailureClass>) failureClassDAO.getAllFailures();
		assertEquals(failureClass.size(),1);
		assertEquals(failureClass.get(0).getDescription(),"EMERGENCY");
		assertEquals(failureClass.get(0).getFailureClass().toString(),"1");
	}
	
	@Test @InSequence(4)
	public void eventCauseTesting(){		
		List<EventCause> eventCause = (List<EventCause>) eventDAO.getAllEvents();
		assertEquals(eventCause.get(0).getCauseCode().toString(),"4097");
		assertEquals(eventCause.get(0).getEventId().toString(),"1");
		assertEquals(eventCause.get(0).getDescription(),"RRC CONN SETUP-SUCCESS");
	}
	
	@Test @InSequence(5)
	public void ueTypeTableTesting(){
		List<UETypeClass>ueType = (List<UETypeClass>) ueTypeDAO.getAllUEType();
		assertEquals(ueType.get(0).getTac().toString(),"100100");
		assertEquals(ueType.get(0).getMarketingName(),"G410");
		assertEquals(ueType.get(0).getManufacturer(),"Mitsubishi");
		assertEquals(ueType.get(0).getAccessCapability(),"GSM 1800");
		assertEquals(ueType.get(0).getModel(),"GSM 900");
		assertEquals(ueType.get(0).getVendorName(),"G410");
		assertEquals(ueType.get(0).getUeType(),"null");
		assertEquals(ueType.get(0).getOs(),"null");
		assertEquals(ueType.get(0).getInputMode(),"null");
	}
	
	@Test @InSequence(6)
	public void sysUserTableTesting(){
		List<SysUser>sysUser = (List<SysUser>) sysUserDAO.getAllUsers();
		assertEquals(sysUser.get(0).getUserName(),"navi");
		assertEquals(sysUser.get(0).getUserPassword(),"123");
		assertEquals(sysUser.get(0).getUserType(),"developer");
	}

	@Test @InSequence(7)
	public void mccMncTesting(){		
		List<MccData> mccData = (List<MccData>) mccMncDataDAO.getAllMccData();
		assertEquals(mccData.get(0).getMcc(),238);
		assertEquals(mccData.get(0).getMnc(),1);
		assertEquals(mccData.get(0).getCountry(),"Denmark");
		assertEquals(mccData.get(0).getOperator(),"TDC-DK");
	}	
}