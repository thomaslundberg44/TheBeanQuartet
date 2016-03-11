package com.the_bean_quartet.msc_project.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.MccData;

public class BaseDataConsistencyCheck {
	
	private BaseData data;
	
	private Collection<MccData> mccList;
	
	public BaseDataConsistencyCheck(BaseData data, Collection<MccData> mccList) {
		this.data = data;
		this.mccList = mccList;
	}
	
	public boolean checkBaseDataConsistency() {
		if(!dateTimeConsistent(data.getDate()))
			return false;
		if(!mccMncIsValid(data.getMccData().getMcc(), data.getMccData().getMnc()))
			return false;
		
		return true;
	}

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
	
	public boolean mccMncIsValid(int mcc, int mnc) {
		for(MccData mccData : mccList) {
			if(mccData.getMcc() == mcc && mccData.getMnc()== mnc)
				return true;
			
		}
		return false;
	}

}
