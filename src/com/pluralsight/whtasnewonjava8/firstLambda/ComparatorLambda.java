package com.pluralsight.whtasnewonjava8.firstLambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

	public static void main(String[] args) {
		
		// usando classe anonima para instanciar um Comparator
		@SuppressWarnings("unused")
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		
		// usando Lambda Expressions
		Comparator<String> comparatorLambda = (String first, String second) -> Integer.compare(first.length(), second.length());
		
		List<String> list = Arrays.asList("**", "****", "********", "*");
		Collections.sort(list, comparatorLambda);
		
		for (String string : list) {
			System.out.println(string);
		}
		
	}
	
}