package com.pluralsight.whtasnewonjava8.lambdaandstream.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		
		Comparator<Integer> comparator = Integer::compare;
		List<Integer> lista = Arrays.asList(1, 454, 23, 864, 12, 0);
		
		Collections.sort(lista, comparator);
		
		for (Integer integer : lista) {
			System.out.println(integer);
		}
		
	}
	
}