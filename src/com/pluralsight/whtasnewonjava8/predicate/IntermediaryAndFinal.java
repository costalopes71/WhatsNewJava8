package com.pluralsight.whtasnewonjava8.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

	public static void main(String[] args) {
		
		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
		List<String> result = new ArrayList<>();
		
		Predicate<String> p1 = Predicate.isEqual("two");
		Predicate<String> p2 = Predicate.isEqual("five");
		
		stream.
			peek(System.out::println).
			filter(p1.or(p2)).
			peek(result::add);
		
		System.out.println("Intermediary methods:");
		System.out.println("result list size = " + result.size());
		
		Stream<String> stream2 = Stream.of("one", "two", "three", "four", "five");
		List<String> result2 = new ArrayList<>();
		
		System.out.println("");
		System.out.println("Final methods (for each) triggering other intermediary methods");
		stream2.peek(System.out::println).filter(p1.or(p2)).forEach(result2::add);
		
		System.out.println("result list2 size = " + result2.size());
		
	}
	
}