package com.pluralsight.whtasnewonjava8.newdateapi.instantAndPeriod;

import java.time.Duration;
import java.time.Instant;

public class InstantAndDurationConcepts {

	// representa um ponto em uma linha de tempo! Tem precisao de nano segundos na linha do tempo.
	/* Convencoes:
		- Instant 0 eh meia noite GMT de 1 de Janeiro de 1970
		- Instant.MIN eh 1 bilhao de anos atras
		- Instant.MAX eh 31 de dezembro de 1.000.000.000
		- Instant.now eh o instante agora
		Ou seja a linha do tempo para o Instant comeca a 1 bilhao de anos atras do instante de agora e vai ate o ano 1 bilhao
		Um objeto Instant eh IMUTAVEL
	*/
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Instant start = Instant.now();
		
		// some long computation
		
		Instant end = Instant.now();
		
		// Segundo conceito: Duration
		// eh o tempo entre dois instantes!
		Duration elapsed = Duration.between(start, end);
		long millis = elapsed.toMillis();
		elapsed.toSeconds();
		elapsed.toDays();
		elapsed.toMinutes();
		
		Duration subtracted = elapsed.minusNanos(1092); // subtraira 1092 nanosegundos e retornara uma copia com os nanosegundos subtraidos
		Duration added = elapsed.plusNanos(928); // adiciona 928 nano segundos e retorna uma copia com os nanosegundos adicionados
		
		// ainda temos tbm os seguintes metodos:
		elapsed.multipliedBy(2);
		elapsed.dividedBy(3);
		elapsed.negated();
		
		boolean isZero = elapsed.isZero();
		boolean isNegative = elapsed.isNegative();
		
	}
	
}
