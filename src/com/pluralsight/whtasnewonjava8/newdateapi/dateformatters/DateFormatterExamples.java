package com.pluralsight.whtasnewonjava8.newdateapi.dateformatters;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterExamples {

	// a nova api possui a classe DateTimeFormatter para formatar datas
	// possui um set de formatos predinidos que estao disponiveis como constantes
	
	public static void main(String[] args) {
		
		ZonedDateTime nextMeetingUs = ZonedDateTime.of(
					LocalDate.of(2018, Month.JULY, 24),
					LocalTime.of(23, 15),
					ZoneId.of("US/Central")
				);
		
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMeetingUs));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeetingUs));
		
	}
	
}
