package com.pluralsight.whtasnewonjava8.lambdaandstream.reduction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

	public static void main(String[] args) {
		
		// empty list
		List<Integer> emptyIntegers = Arrays.asList();
		// lista com valores
		List<Integer> integers = Arrays.asList(3, 2, 8, 17);
		
		// como a lista integers eh vazia, eh usado o Integer identity (primeiro parametro do reduce), que no caso deve ser 0 por se tratar
		// de uma adicao
		Integer sum = emptyIntegers.stream().reduce(0, (i, i1) -> i + i1);
		System.out.println("Sum = " + sum);
		
		Integer sumWithMethodReference = emptyIntegers.stream().reduce(0, Integer::sum);
		System.out.println("Sum with method reference: " + sumWithMethodReference);
		
		// com valores
		Integer sum2 = integers.stream().reduce(0, (firstOperand, secondOperand) -> firstOperand + secondOperand);
		// ou
		Integer sum2WithMethodReference = integers.stream().reduce(0, Integer::sum);
		System.out.println("not empty list sum = " + sum2);
		System.out.println("not empty list sum = " + sum2WithMethodReference);
		
		// operacoes de agregacao (max, min, avg, etc)
		Optional<Integer> max = integers.stream().reduce((i, i1) -> i > i1 ? i : i1);
		System.out.println("not empty list max value " + max.orElse(0));
		// ou
		Optional<Integer> maxWithMethodReference = integers.stream().reduce(Integer::max);
		System.out.println("not empty list max value with method reference " + maxWithMethodReference.orElse(0));
		
		Optional<Integer> noValueMax = emptyIntegers.stream().reduce(Integer::max);
		System.out.println("reduction agregation on empty list = " + noValueMax);
		
	}
	
}