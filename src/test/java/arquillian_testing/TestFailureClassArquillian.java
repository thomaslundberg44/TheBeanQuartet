package arquillian_testing;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.FailureClass;

@RunWith(Arquillian.class)
public class TestFailureClassArquillian {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(FailureClass.class)
				.addClass(BaseData.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Inject FailureClass failure;
	
	@Test
	public void test() {
		failure.setDescription("Boom");
		assertEquals(failure.getDescription(),"Boom");
	}

}
