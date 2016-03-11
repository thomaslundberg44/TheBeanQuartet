package utilties_testing;

import static com.the_bean_quartet.msc_project.utilities.BaseDataConsistencyCheck.dateTimeConsistent;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.utilities.BaseDataConsistencyCheck;

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
	
	@Test
	public void testMccMncIsValid() {
		// create some mock mcc data items with valid values
		ArrayList<MccData> mccList = new ArrayList<MccData>();
		mccList.add(new MccData(344,930,"Antigua and Barbuda","AT&T Wireless-Antigua AG"));
		mccList.add(new MccData(238,1,"Denmark","TDC-DK"));
		mccList.add(new MccData(505,90,"Australia","Optus Ltd. AU"));
		mccList.add(new MccData(440,11,"Japan","NTT DoCoMo"));
		
		BaseDataConsistencyCheck check = new BaseDataConsistencyCheck(new BaseData());
		check.setMccList(mccList);
		
		// *----- Valid partitions --- Valid combinations of MCC/MNC's
		
		assertTrue(check.mccMncIsValid(344,930));
		assertTrue(check.mccMncIsValid(238, 1));
		assertTrue(check.mccMncIsValid(505, 90));
		assertTrue(check.mccMncIsValid(440, 11));
		
		
		// *----- Invalid partitions --- Invalid combinations of MCC/MNC's
		
		assertFalse(check.mccMncIsValid(240, 36));
		assertFalse(check.mccMncIsValid(440, 0));
		assertFalse(check.mccMncIsValid(505, 11));
		assertFalse(check.mccMncIsValid(405, 9));
		
	}
	
	@Test
	public void testEventIdCauseCodeValid() {
		ArrayList<EventCause> events = new ArrayList<EventCause>();
		events.add(new EventCause(4097,0,"RRC CONN SETUP-SUCCESS"));
		events.add(new EventCause(4097,1,"RRC CONN SETUP-UNSPECIFIED"));
		events.add(new EventCause(4098,0,"S1 SIG CONN SETUP-SUCCESS"));
		events.add(new EventCause(4125,10,"UE CTXT RELEASE-USER INACTIVITY"));
		
		BaseDataConsistencyCheck check = new BaseDataConsistencyCheck(new BaseData());
		check.setEventList(events);
		
		// *------ test valid partitions -----------
		
		assertTrue(check.eventIdCauseCodeValid(4097,0));
		assertTrue(check.eventIdCauseCodeValid(4098,0));
		assertTrue(check.eventIdCauseCodeValid(4125,10));
		
		
		// *----- Test invalid partitions ---------
		
		assertFalse(check.eventIdCauseCodeValid(4099,0));
		assertFalse(check.eventIdCauseCodeValid(5059,99));
		assertFalse(check.eventIdCauseCodeValid(4097,18));
	}
	
	@Test
	public void testBaseDataConsistency() {
		
		ArrayList<MccData> mccList = new ArrayList<MccData>();
		mccList.add(new MccData(344,930,"Antigua and Barbuda","AT&T Wireless-Antigua AG"));
		mccList.add(new MccData(238,1,"Denmark","TDC-DK"));
		mccList.add(new MccData(505,90,"Australia","Optus Ltd. AU"));
		mccList.add(new MccData(440,11,"Japan","NTT DoCoMo"));
		
		ArrayList<EventCause> events = new ArrayList<EventCause>();
		events.add(new EventCause(4097,0,"RRC CONN SETUP-SUCCESS"));
		events.add(new EventCause(4097,1,"RRC CONN SETUP-UNSPECIFIED"));
		events.add(new EventCause(4098,0,"S1 SIG CONN SETUP-SUCCESS"));
		events.add(new EventCause(4125,10,"UE CTXT RELEASE-USER INACTIVITY"));
		
		BaseData data = new BaseData();
		
		BaseDataConsistencyCheck check = new BaseDataConsistencyCheck(data);
		check.setEventList(events);
		check.setMccList(mccList);
		
		// *----- Test valid partitions -----------
		data.setDate("2014/1/25 17:45:00");
		data.setEventCause(new EventCause(4097,0,""));
		data.setMccData(new MccData(344,930,"",""));
		
		assertTrue(check.checkBaseDataConsistency());
		
		// *----- Test invalid partitions ----------
		
		// fail on date branch
		data.setDate("1982/2/29 13:30:00");
		assertFalse(check.checkBaseDataConsistency());
		
		// fail on mcc branch
		data.setDate("2014/1/25 17:56");
		data.setMccData(new MccData(439, 615,"",""));
		assertFalse(check.checkBaseDataConsistency());
		
		// fail on event id branch
		data.setMccData(mccList.get(0));
		data.setEventCause(new EventCause(4099, 0, ""));
		assertFalse(check.checkBaseDataConsistency());
		
		// fail on cause code branch
		data.setEventCause(new EventCause(4097, 99, ""));
		assertFalse(check.checkBaseDataConsistency());
		
	}
}
