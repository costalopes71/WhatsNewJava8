package com.pluralsight.whtasnewonjava8.strings.stringjoiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerExample {

	/*
 	Muitas pessoas dizem para nao usar concatenacao de strings com + pois nao eh eficiente e etc.
 	Dizem para usar o StringBuffer, entretanto, se nao estamos em uma aplicacao multithread, nao eh a melhor maneira pois ele
 	eh sincronizado. No java 5 existe uma melhor maneira que eh a classe StringBuilder que eh praticamente a mesma coisa porem
 	nao eh sincronizado, entao eh melhor.
  	ENTRETANTO, a partir do JDK7 a JVM eh capaz de determinar se um StringBuffer nao eh chamado em um ambiente multithread, a JVM
  	remove automaticamente a sincronizacao, ou seja, na verdade StringBuffer sera tao eficiente quanto StringBuilder.
  	Mais ainda, a partir do JDK7 a concatenacao de String com o sinal de + ja compila com um StringBuilder, ou seja, voce nao pre-
  	cisa de maneira nenhuma a partir do JDK7 usar um StringBuilder.
  	No JDK 8 foi introduzido a classe StringJoiner que nos auxilia a concatenar String com separadores e prefixos e sufixos
 */
	
	public static void main(String[] args) {
		
		// joiner com delimitador ;
		StringJoiner sj = new StringJoiner(";");
		sj.add("one").add("two").add("three");
		System.out.println(sj.toString());
		
		//joiner vazio com delimitador, prefixo e sufico
		StringJoiner sj2 = new StringJoiner(";", "{", "}");
		String s = sj2.toString();
		System.out.println(s); // print {}
	
		// com apenas um elemento (corner cases)
		sj2.add("one");
		System.out.println(sj2.toString()); // print {one} 

		//
		// posso usar o metodo join diretamente na classe String (so nao posso usar prefixos e sufixos no metodo join)
		//
		List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six"));
		
		String s2 = String.join(";", "um", "dois", "três");
		System.out.println(s2); // prints um;dois;três
	
		// posso passar diretamente um array ou uma Collection tbm
		String s3 = String.join(";", list);
		System.out.println(s3); // prints one;two;three;four;five;six
		
	}
	
}