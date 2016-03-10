package utilties_testing;

import static com.the_bean_quartet.msc_project.utilities.BaseDataConsistencyCheck.dateTimeConsistent;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class TestBaseDataConsistencyChecks {

	@Test
	public void testDateTimeConsistent() {

		
		// *--- test valid partitions ---*
		
		String date = "2016/1/01 12:55";
		assertTrue(dateTimeConsistent(date));
		
		date = "2015/8/12 21:32";
		assertTrue(dateTimeConsistent(date));
		
		// test 29 days in leap year correct
		date = "2016/2/29 20:54";
		assertTrue(dateTimeConsistent(date));
		
		
		// *--- test invalid partitions ---*
		
		// test for date with days less than zero
		date = "1982/1/0 14:52";
		assertFalse(dateTimeConsistent(date));
		
		// test for day greater than days per month: 31
		date = "2015/1/32 17:54";
		assertFalse(dateTimeConsistent(date));
		
		// test for month less than zero
		date = "2016/0/1 20:32";
		assertFalse(dateTimeConsistent(date));
		
		// test for month greater than 12
		date = "2015/13/12 23:59";
		assertFalse(dateTimeConsistent(date));
		
		// test 29 days is not ok February non-leap year
		date = "2015/2/29 11:40";
		assertFalse(dateTimeConsistent(date));
		
		// check for invalid times
		date = "1992/3/30 25:00";
		assertFalse(dateTimeConsistent(date));
		
		date = "1974/12/25 -1:65";
		assertFalse(dateTimeConsistent(date));
		
		// check if date exceeds current date
		date = "2017/1/25 14:23";
		assertFalse(dateTimeConsistent(date));
		
	}
}
