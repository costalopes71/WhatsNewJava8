package com.pluralsight.whtasnewonjava8.comparators;

import java.util.Comparator;

import com.pluralsight.whtasnewonjava8.lambdaandstream.model.Person;

public class ComparatorsAPI {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// maneira antiga de comparar (JDK 7)
		// ruim pois tenho que implementar a interface para poder usar e nao cuida do caso de p1 ou p2 serem nulos, teria que
		//acionar codigo para ter certeza que uma NullPointerException nao seria propagada.
		Comparator<Person> compareLastName = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		}; 
		
		// outro problema, usar mais de um comparador (2 ou + em serie). Maneira antiga:
		Comparator<Person> compareLastNameAndFirstName = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				int lastNameComparison = o1.getLastName().compareTo(o2.getLastName());
				return lastNameComparison == 0 ? o1.getName().compareTo(o2.getName()) : lastNameComparison;
			}
		};
		
		//nova maneira com JDK 8
		Comparator<Person> compareLastName8 = Comparator.comparing(Person::getLastName);
		
		// comparacoes em serie
		Comparator<Person> compareLastNameThenFirstName = Comparator.comparing(Person::getLastName).
				thenComparing(Person::getName);
		
		// revertendo o comparador
		Comparator<Person> reversed = compareLastNameThenFirstName.reversed();
		
		// comparando objetos que ja sao comparaveis (por exemplo String, Integers etc)
		Comparator<String> c = Comparator.naturalOrder(); // lexicograficamente
		
		// lidando com nulos
		Comparator<String> nullsFirst = Comparator.nullsFirst(Comparator.naturalOrder()); // nulos postos no comeco da lista
		Comparator<String> nullsLast = Comparator.nullsLast(Comparator.naturalOrder()); // nulos no fim da lista
		
	}
	
}