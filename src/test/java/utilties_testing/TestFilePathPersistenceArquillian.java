package utilties_testing;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.the_bean_quartet.msc_project.services.BaseDataService;
import com.the_bean_quartet.msc_project.services.ErrorDataService;
import com.the_bean_quartet.msc_project.services.EventCauseService;
import com.the_bean_quartet.msc_project.services.FailureDataService;
import com.the_bean_quartet.msc_project.services.FilePathService;
import com.the_bean_quartet.msc_project.services.MccDataService;
import com.the_bean_quartet.msc_project.services.UETypeService;
import com.the_bean_quartet.msc_project.utilities.FileSystemWatch;
import com.the_bean_quartet.msc_project.utilities.ProcessXLSFile;

@RunWith(Arquillian.class)
public class TestFilePathPersistenceArquillian {
	
	@Inject private FileSystemWatch fileWatch;
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClasses(FileSystemWatch.class, FilePathService.class, 
						ProcessXLSFile.class, FilePathService.class)
				.addClasses(BaseDataService.class, ErrorDataService.class, FailureDataService.class,
						EventCauseService.class, UETypeService.class, MccDataService.class)
						.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void testFileSystemWatchPath() {
		assertTrue(true);
	}

}
