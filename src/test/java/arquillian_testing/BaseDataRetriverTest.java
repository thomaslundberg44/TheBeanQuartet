package arquillian_testing;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.junit.Test;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import com.the_bean_quartet.msc_project.dao.BaseDataDAO;
import com.the_bean_quartet.msc_project.dao.jpa.JPABaseDataDAO;
import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.services.BaseDataService;
import com.the_bean_quartet.msc_project.services.BaseDataServiceEJB;


@RunWith(Arquillian.class)
public class BaseDataRetriverTest {
	
	@EJB
	BaseDataService baseDataService;
	//BaseDataDAO baseDataDao;
	
	@Deployment
	public static JavaArchive createDeployment() {
	    return ShrinkWrap.create(JavaArchive.class, "test.jar")
	        .addPackage(BaseDataServiceEJB.class.getPackage())
	        .addPackage(BaseData.class.getPackage())
	        .addPackage(JPABaseDataDAO.class.getPackage())
	        .addPackage(BaseDataDAO.class.getPackage())
	        .addAsManifestResource("META-INF/PersistenceOne.xml", "persistence.xml")
	        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	  }
	
	
	@Test
	public void testThatTheEJBReturnsTheRightValue() {
		assertEquals(baseDataService.getIMSIData().size(),6);
		assertTrue(baseDataService.getEachImsiBaseData("11/01/2013 17:15", "11/01/2013 18:15").isEmpty());
		assertTrue(baseDataService.getListImsiWithFailureTimeRange("11/01/2013 17:15", "11/01/2013 18:15").isEmpty());
		assertFalse(baseDataService.getSelectedBaseData("344930000000011").isEmpty());
		assertFalse(baseDataService.getModelData().isEmpty());
		assertTrue(baseDataService.getListImsiWithFailureTimeRange("11/01/2013 17:15", "11/01/2013 18:15").isEmpty());
		assertFalse(baseDataService.getImsiFailureCount("344930000000011", "11/01/2013 17:15", "11/01/2013 18:15").isEmpty());
		assertTrue(baseDataService.getTop10ImsiBaseData("11/01/2013 17:15", "11/01/2013 18:15").isEmpty());
	}
	
	
}
