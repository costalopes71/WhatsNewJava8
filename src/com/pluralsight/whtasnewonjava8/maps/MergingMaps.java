package com.pluralsight.whtasnewonjava8.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pluralsight.whtasnewonjava8.maps.model.Person;

public class MergingMaps {

	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>();
		
		try (
				BufferedReader reader = new BufferedReader(
					new InputStreamReader(
						MergingMaps.class.getResourceAsStream("people.txt")
					)
				);
			
				Stream<String> stream = reader.lines();
				
			) {
			
			stream.forEach(line -> {
				String[] tokens = line.split(" ");
				people.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		List<Person> list1 = people.subList(0, 10);
		List<Person> list2 = people.subList(10, people.size());
		
		System.out.println("Map 1");
		Map<Integer, List<Person>> map1 = mapByAge(list1);
		map1.forEach((age, listPeople) -> System.out.println(age + " -> " + listPeople));
		System.out.println("\nMap2");
		Map<Integer, List<Person>> map2 = mapByAge(list2);
		map2.forEach((age, listPeople) -> System.out.println(age + " -> " + listPeople));
		
		//
		// fazendo o merge do map2 no map1
		//
		map2.entrySet().stream().forEach( entry -> {
			map1.merge(
				entry.getKey(), 
				entry.getValue(), 
				(l1, l2) -> {
					l1.addAll(l2);
					return l1;
				}
			);
		});
		
		System.out.println("\nMerged map");
		map1.forEach((key, value) -> System.out.println(key + " -> " + value));
		
	}
	
	private static Map<Integer, List<Person>> mapByAge(List<Person> list) {
		return list.stream().collect(Collectors.groupingBy(Person::getAge));
	}
	
}
