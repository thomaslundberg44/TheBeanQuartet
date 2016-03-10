package com.the_bean_quartet.msc_project.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.the_bean_quartet.msc_project.entities.BaseData;

public class BaseDataConsistencyCheck {
	
	private BaseData data;
	
	public BaseDataConsistencyCheck(BaseData data) {
		this.data = data;
	}
	
	public boolean checkBaseDataConsistency() {
		return dateTimeConsistent(data.getDate());
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

}
