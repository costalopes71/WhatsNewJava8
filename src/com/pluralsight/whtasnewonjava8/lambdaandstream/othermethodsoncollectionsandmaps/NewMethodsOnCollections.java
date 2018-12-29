package com.pluralsight.whtasnewonjava8.lambdaandstream.othermethodsoncollectionsandmaps;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class NewMethodsOnCollections {

	public static void main(String[] args) {
		
		// exemplo de remocao de elemento com um predicado (nao funciona se a lista for imutavel)
		Collection<String> example = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
		
		boolean b = example.removeIf(s -> s.length() > 4);
		
		System.out.println("A colecao foi modificada: " + b);
		System.out.println(example.stream().collect(Collectors.joining(", ")));
		
		// novo metodo replaceAll em List que espera uma Function como parametro
		List<String> list = new ArrayList<>(example);
		// list.replaceAll(s -> s.toUpperCase()); posso fazer assim ou
		list.replaceAll(String::toUpperCase); // usando method reference
		
		System.out.println(list.stream().collect(Collectors.joining(", ")));
		
		// metodo sort de List
		List<String> example2 = new ArrayList<>(Arrays.asList("Área", "Finda", "Mozart", "Catavento", "Caçamba"));
		example2.sort(Comparator.naturalOrder());
		System.out.println(example2.stream().collect(Collectors.joining(", ")));

		// comparando de forma correta para o portugues brasil
		Collator col = Collator.getInstance(Locale.forLanguageTag("pt_BR"));
		example2.sort(col);
		System.out.println(example2);
		
	}
	
}