package utilties_testing;

import java.io.File;

import org.junit.Test;

import com.the_bean_quartet.msc_project.utilities.ProcessXLSFile;

public class TestProcessFile {

	@Test
	public void testProcessFile() {
		ProcessXLSFile process = new ProcessXLSFile();
		
		File file = new File("/home/tommy/Documents/incorrect_data.xls");
		
		process.processXLSSpreadsheet(file);
	}

}
