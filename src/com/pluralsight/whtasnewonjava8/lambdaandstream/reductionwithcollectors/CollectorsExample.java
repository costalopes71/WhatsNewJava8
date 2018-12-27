package com.pluralsight.whtasnewonjava8.lambdaandstream.reductionwithcollectors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pluralsight.whtasnewonjava8.lambdaandstream.model.Person;

public class CollectorsExample {

	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
		
		try (
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								CollectorsExample.class.getResourceAsStream("people.txt"))); 
				Stream<String> stream = reader.lines();
			) 
		{
			
			stream.map(line -> {
				String[] tokens = line.split(" ");
				Person person = new Person(tokens[0].trim(), Integer.parseInt(tokens[1]));
				persons.add(person);
				return person;
				}
			).forEach(System.out::println);;
			
			System.out.println(persons);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// obtendo a pessoa mais nova da lista das que tenham 20 ou mais anos
		Optional<Person> optMinAge = persons.stream().filter(p -> p.getAge() >= 20).min(Comparator.comparing(Person::getAge));
		System.out.println("Mais novo : " + optMinAge);
		
		Optional<Person> optMaxAge = persons.stream().max(Comparator.comparing(Person::getAge));
		System.out.println("Mais velho: " + optMaxAge);
		
		// usando collectors
		Map<Integer, List<Person>> agesMap = persons.stream().collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Mapa de idade e lista de pessoas: " + agesMap);
		
		// usando downstream collector
		Map<Integer, Long> agesQttMap = persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
		System.out.println("quantidade de pessoas com idade: " + agesQttMap);
		
		Map<Integer, List<String>> agesAndNamesMap = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println("ages and names: " + agesAndNamesMap);
		
		Map<Integer, Set<String>> agesAndNamesTreeSet = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))));
		System.out.println("ages and names: " + agesAndNamesTreeSet);
		
		Map<Integer, String> agesAndStringMap = persons.stream().collect(Collectors.groupingBy(Person::getAge, 
				Collectors.mapping(Person::getName, Collectors.joining(", "))));
		System.out.println("like string: " + agesAndStringMap);
		
	}
	
}