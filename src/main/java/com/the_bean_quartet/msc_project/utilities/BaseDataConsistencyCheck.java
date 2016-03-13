package com.the_bean_quartet.msc_project.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.MccData;

public class BaseDataConsistencyCheck {
	
	private BaseData data;
	
	private Collection<MccData> mccList;
	private Collection<EventCause> eventList;
	
	public BaseDataConsistencyCheck(BaseData data) {
		this.data = data;
	}

	public void setMccList(Collection<MccData> mccList) {
		this.mccList = mccList;
	}

	public void setEventList(Collection<EventCause> eventList) {
		this.eventList = eventList;
	}

	/**
	 * Check incoming data object for inconsistency. 
	 * Test based on date/time, valid mcc/mnc combinations and 
	 * valid eventId/causeCode combinations
	 * 
	 * @return returns true for consistent data
	 */
	public boolean checkBaseDataConsistency() {
		if(!dateTimeConsistent(data.getDate()))
			return false;
		if(!mccMncIsValid(data.getMccData().getMcc(), data.getMccData().getMnc()))
			return false;
		if(!eventIdCauseCodeValid(data.getEventCause().getEventId(), data.getEventCause().getCauseCode()))
			return false;
		
		return true;
	}

	/**
	 * Checks a date for consistency in format yyyy/mm/dd hh:mm.
	 * Also checks for dates that exceed current date or invalid day/month
	 * 
	 * @param A date in string format
	 * @return return false for date that exceeds current date, date that does
	 * not follow correct format or date with invalid number of days/months
	 */
	public static boolean dateTimeConsistent(String dateStr) {

		// will throw an exception if date is invalid
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		sdf.setLenient(false);
		Date date;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			return false;
		}

		// will return false if date exceeds current date
		Date now = new Date();
		return date.before(now);
	}
	
	/**
	 * Searches for valid combination of both MCC and MNC
	 * 
	 * @param The mobile country code
	 * @param The Mobile network operator code
	 * @return returns true for valid combinations of mcc/mnc
	 */
	public boolean mccMncIsValid(int mcc, int mnc) {
		for(MccData mccData : mccList) {
			if(mccData.getMcc() == mcc && mccData.getMnc()== mnc)
				return true;
			
		}
		return false;
	}
	
	/**
	 * Searches for valid combinations of both evend id and cause code
	 * 
	 * @param The event id for an event
	 * @param The cause code for an event
	 * @return Returns true for a valid combination of event id and cause code
	 */
	public boolean eventIdCauseCodeValid(int eventId, int causeCode) {
		for(EventCause event : eventList) {
			if(event.getEventId() == eventId 
					&& event.getCauseCode() == causeCode)
				return true;
		}
		return false;
	}

}
