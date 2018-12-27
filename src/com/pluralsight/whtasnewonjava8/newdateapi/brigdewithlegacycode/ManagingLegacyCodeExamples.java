package com.pluralsight.whtasnewonjava8.newdateapi.brigdewithlegacycode;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

public class ManagingLegacyCodeExamples {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// Instant & Date
		Instant now = Instant.now();
		Date date = Date.from(now); // API -> legacy
		Instant instant = date.toInstant(); // legacy -> API
		
		/*
		 *  nao funciona mais no java 10 (nao sei pq, talvez foi descontinuado e retirado do JDK 10 a classe TimeStamp
		 *  TimeStamp time = TimeStamp.from(instant); --> API -> legacy
		 *  Instant instant = time.toInstant(); -> Legacy -> API
		 */
		
		/*
		 * tbm nao funciona no jdk 10
			LocalDate now2 = LocalDate.now();
			Date date2 = Date.from(now2);
			LocalDate localDate2 = date2.toLocalDate();
		 */
		
		// nao funciona no jdk 10 Time time = Time.from(localDate2);
		Time time = Time.valueOf(LocalTime.now()); // API -> legacy
		LocalTime localTime = time.toLocalTime(); // legacy -> API
		
	}
	
}