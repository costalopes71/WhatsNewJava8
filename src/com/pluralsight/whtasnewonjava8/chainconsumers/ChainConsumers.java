package com.pluralsight.whtasnewonjava8.chainconsumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {

	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
		List<String> result = new ArrayList<>();
		
		Consumer<String> c1 = mensagem -> System.out.println(mensagem);
		// ou
		Consumer<String> c1_v2 = System.out::println;
		
		Consumer<String> c2 = mensagem -> result.add(mensagem);
		// ou
		Consumer<String> c2_v2 = result::add;
		
		strings.forEach(c1_v2.andThen(c2_v2));
		
		System.out.println(result.size());
		
	}
	
}