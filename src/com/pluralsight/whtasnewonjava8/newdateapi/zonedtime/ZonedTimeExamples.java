package com.pluralsight.whtasnewonjava8.newdateapi.zonedtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedTimeExamples {

	// ZonedTime servem para lidar com os fusos horarios, horario de verao, horario de inverno e etc
	public static void main(String[] args) {
		
		// devolve um set com todos os fusos horarios
		Set<String> zones = ZoneId.getAvailableZoneIds();
		zones.stream().forEach(System.out::println);
		
		ZoneId spTZ = ZoneId.of("America/Sao_Paulo");
		System.out.println("\nFuso horario de Sao Paulo: " + spTZ);
		
		//criando um tempo determinado em um fuso horario determinado
		ZonedDateTime shakespeareBirthInUkZT = ZonedDateTime.of(
					1564, //ano
					Month.APRIL.getValue(), // mes
					23, // dia do mes
					10, // hora
					0, // minuto
					0, //segundo
					0, // nano segundo
					ZoneId.of("Europe/London") // zona
				);
		System.out.println("\nNascimento de Shakespeare no fuso horario ingles: " + shakespeareBirthInUkZT);
		
		// ZoneDateTime tbm tem varios metodos para computar outros horarios em outras zona: plus, minus, with, etc
		ZonedDateTime reuniaoEmLondres = ZonedDateTime.of(
					LocalDate.of(2018, Month.DECEMBER, 31),
					LocalTime.of(23, 59),
					ZoneId.of("Europe/London")
				);
		
		ZonedDateTime proximaReuniao = reuniaoEmLondres.plus(Period.ofMonths(1));
		System.out.println("\nA proxima reuniao em londres eh as: " + proximaReuniao);
		
		ZonedDateTime proximaReuniaoNoBrasil = proximaReuniao.withZoneSameInstant(ZoneId.of("America/Sao_Paulo"));
		System.out.println("A proxima reuniao em SP eh as: " + proximaReuniaoNoBrasil);
		
	}
	
}