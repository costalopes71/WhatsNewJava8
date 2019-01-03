package com.pluralsight.whtasnewonjava8.annotations;

public class NewsOnAnnotations {

	//antes do java 8
	//Varias anotacoes iguais deviam ser encapsuladas em outra. Exemplo:
	@TestCases({
		@TestCase(param=1, expected=false),
		@TestCase(param=2, expected=true)
	})
	public boolean even(int param) {
		return param % 2 ==0;
	}

	
	//a partir do java 8 uma anotacao pode ser repetivel!
	@TestCase(param=1, expected=false)
	@TestCase(param=2, expected=true)
	public boolean even2(int param) {
		return param % 2 ==0;
	}
	
	//TODO entender pq nao esta compilando
	/*
		// Novidades java 8
		// Declara uma variavel que NAO PODE SER NULA
		private @NonNull List<Person> persons; 
		
		// declaro que essa lista nao pode ser nula e nao pode ter valores nulos
		private @NonNull List<@NonNull Person> persons2;
		
	*/
	
}