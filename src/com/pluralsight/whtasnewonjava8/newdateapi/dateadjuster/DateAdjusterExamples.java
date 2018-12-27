package com.pluralsight.whtasnewonjava8.newdateapi.dateadjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DateAdjusterExamples {

	// serve para adicionar ou subtrair uma quantidade de tempo a um Instant ou a um LocalDate
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// apenas dia/mes/ano
		LocalDate now = LocalDate.now();
		// dia/mes/ano hh:mm:ss:nanosegundos
		LocalDateTime now2 = LocalDateTime.now();
		
		// proximo domingo
		LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		
		// imprime o proximo domingo a partir da data de agora
		System.out.println(nextSunday);
		
		// metodos estaticos de TemporalAdjuster para ajustar um Instant ou LocalDate:
		/*
		 *  - firstDayOfMonth, lastDayOfMonth
		 *  - firstDayOfYear, lastDayOfYear
		 *  - firstDayOfNextMonth, firstDayOfNextYear
		 *  - firstInMonth(DayOfWeek.MONDAY)
		 *  - lastInMonth(DayOfWeek.TUESDAY)
		 *  - dayOfWeekInMonth(2, DayOfWeek.THURSDAY)
		 *  - next(DayOfWeek.SUNDAY)
		 *  - nextOrSame(DayOfWeek.SUNDAY)
		 *  - previous(DayOfWeek.SUNDAY)
		 *  - previousOrSame(DayOfWeek.SUNDAY)
		 */
		
		// a segunda sexta do mes
		LocalDateTime secondFriday = now2.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY));
		System.out.println(secondFriday);
		
	}
	
}
