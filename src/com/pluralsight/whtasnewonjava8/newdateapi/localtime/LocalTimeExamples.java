package com.pluralsight.whtasnewonjava8.newdateapi.localtime;

import java.time.LocalTime;

public class LocalTimeExamples {

	// um LocalTime eh um horario no dia Ex: 10:20
	
	public static void main(String[] args) {
		
		LocalTime now = LocalTime.now();
		// meia noite eh 00h e nao 24h.
		LocalTime midnight = LocalTime.of(00, 00); 
		
		System.out.println(now);
		System.out.println(midnight);
		
		// tbm posso manipular os LocalTime adicionando horas e etc
		LocalTime bedTime = LocalTime.of(23, 00);
		LocalTime wakeupTime = bedTime.plusHours(8);
		
		System.out.println("Bed time: " + bedTime);
		System.out.println("Wakeup time: " + wakeupTime);
		
	}
	
}