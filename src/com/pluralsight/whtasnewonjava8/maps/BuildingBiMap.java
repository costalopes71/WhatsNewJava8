package com.pluralsight.whtasnewonjava8.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.pluralsight.whtasnewonjava8.maps.model.Person;

public class BuildingBiMap {

	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>();
		
		try (
				BufferedReader reader = new BufferedReader(
					new InputStreamReader(
						BuildingBiMap.class.getResourceAsStream("people.txt")
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
		
		Map<Integer, Map<String, List<Person>>> bimap = new HashMap<>();
		
		people.forEach(
			person -> 
			bimap.computeIfAbsent(person.getAge(), HashMap::new).merge(
				person.getGender(), 
				new ArrayList<>(Arrays.asList(person)), 
				(l1, l2) -> {
					l1.addAll(l2);
					return l1;
				})
			);
		
		System.out.println("Bimap: ");
		bimap.forEach((age, map) -> System.out.println(age + " -> " + map));
		
	}
	
}
