package com.pluralsight.whtasnewonjava8.strings;

import java.util.stream.IntStream;

public class StringWithStream {

	// novo metodo na classe String: .chars() devolve um IntStream
	public static void main(String[] args) {
		
		String s = "Hello World!";
		IntStream chars = s.chars();
		
		chars.mapToObj(letter -> (char) letter)
			.map(Character::toUpperCase)
			.forEach(System.out::print);
		
	}
	
}