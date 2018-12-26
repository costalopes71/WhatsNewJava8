package com.pluralsight.whtasnewonjava8.newdateapi.dateandcalendar;

import java.util.Calendar;
import java.util.Date;

public class OldDateApi {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 1, 10);
		
		Date feb10th = cal.getTime();
		
		// adicionando 7 dias a data
		cal.add(Calendar.DAY_OF_MONTH, 7);
		Date oneWeekLater = cal.getTime();
		
	}
	
}
