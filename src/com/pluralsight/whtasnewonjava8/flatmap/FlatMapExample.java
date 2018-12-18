package com.pluralsight.whtasnewonjava8.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {
	
	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(2, 4, 6);
		List<Integer> list3 = Arrays.asList(3, 5, 7);
		
		List<List<Integer>> list = Arrays.asList(list1, list2, list3);

		// map example
		Stream<List<Integer>> stream = list.stream();
		stream.map(l -> l.size()).forEach(System.out::println);
		// extraindo a funcao
		System.out.println("usando a function");
		Function<List<?>, Integer> size = List::size;
		list.stream().map(size).forEach(System.out::println);
		
		// outro exemplo
		System.out.println("funcao que retorna streams com map");
		Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();
		list.stream().map(flatmapper).forEach(System.out::println);
		
		// poe o conteudo de cada Stream em um unico stream
		System.out.println("usando flatmap");
		list.stream().flatMap(flatmapper).forEach(System.out::println);
		
	}
	
}
