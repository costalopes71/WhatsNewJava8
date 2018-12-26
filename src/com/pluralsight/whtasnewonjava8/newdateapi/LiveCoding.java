package com.pluralsight.whtasnewonjava8.newdateapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LiveCoding {

	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
		
		try (
				BufferedReader reader = new BufferedReader(
					new InputStreamReader(LiveCoding.class.getResourceAsStream("people.txt"))
				);
				Stream<String> stream = reader.lines();
			) {
			
			stream.map(
				line -> {
							String[] tokens = line.split(" ");
							String name = tokens[0];
							int year = Integer.parseInt(tokens[1]);
							Month month = Month.of(Integer.parseInt(tokens[2]));
							int day = Integer.parseInt(tokens[3]);
							Person person = new Person(name, LocalDate.of(year, month, day));
							return person;
						}
					).forEach(persons::add);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		LocalDate now = LocalDate.now();
		
		persons.forEach( p -> {
			Period between = Period.between(p.getDathOfBith(), now);
			System.out.println(p.getName() + " was born " + between.get(ChronoUnit.YEARS) + " years and " + 
					between.get(ChronoUnit.MONTHS) + " months ago. [total of: " + 
					p.getDathOfBith().until(now, ChronoUnit.MONTHS) + " months]");
		});
		
	}
	
}