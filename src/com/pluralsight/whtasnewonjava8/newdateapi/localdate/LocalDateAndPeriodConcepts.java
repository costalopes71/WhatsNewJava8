package com.pluralsight.whtasnewonjava8.newdateapi.localdate;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateAndPeriodConcepts {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		LocalDate shakespeareBirth = LocalDate.of(1564, Month.APRIL, 23);
		LocalDate now = LocalDate.now();
		
		// Period: eh a quantidade de tempo entre dois LocalDate (parece com o Duration mas funciona com LocalDate ao inves de Instant)
		Period p = shakespeareBirth.until(now);
		System.out.println("# years = " + p.getYears());
		
		long years = shakespeareBirth.until(now, ChronoUnit.YEARS);
		System.out.println("# years again = " + years);
		
		long days = shakespeareBirth.until(now, ChronoUnit.DAYS);
		System.out.println("# days = " + days);
		
	}
	
}
