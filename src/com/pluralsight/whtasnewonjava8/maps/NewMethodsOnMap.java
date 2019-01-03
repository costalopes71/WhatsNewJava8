package com.pluralsight.whtasnewonjava8.maps;

import java.util.HashMap;
import java.util.Map;

import com.pluralsight.whtasnewonjava8.lambdaandstream.model.Person;

public class NewMethodsOnMap {

	public static void main(String[] args) {
		
		/* forEach : praticamente o mesmo que tem na Iterable interface, mas nesse caso o parametro para ele eh um BiConsumer
		 um BiConsumer eh um consumidor com dois parametros ao inves de um, e eles sao a chave e o valor do mapa
		 */ 
		
		Map<String, Person> map = new HashMap<>();
		map.put("brancos", new Person("Joao", 31));
		map.put("negros", new Person("Jorge", 25));
		map.put("pardos", new Person("Matheus", 20));
		
		map.forEach((key, value) -> System.out.println(key + " " + value));
		
		System.out.println("");
		// metodo GET. Tem um problema que quando eu chamo o GET ele pode retornar NULL e nao posso saber se a chave nao existe no mapa ou se ela
		// esta associada a um valor hull, por isso no java 8 temos o metodo getOrDefault(key, defaultValue) que retornara um valor default caso a
		// chave nao seja encontrada no mapa
		
		Person p = map.getOrDefault("amarelos", new Person("Camila", 19));
		System.out.println(p + "\n");
		
		/*
		 Nova versao do metodo PUT. Se eu usar o metodo put normal, ele ira sobrescrever o valor se ele ja existir e por o novo valor no lugar. Com
		 o novo metodo putIfAbsent ele apenas ira colocar o valor se a chave nao estiver presente no mapa
		 */
		map.putIfAbsent("brancos", new Person("Leticia", 28));
		map.putIfAbsent("vermelhos", new Person("Andre", 35));
		map.forEach((key, value) -> System.out.println(key + " " + value));
	
		System.out.println("\n");
		/*
		 Metodo REPLACE : substitui o valor associado a determinada chave. Posso usar a maneira sobrecarregada que tbm testa se o antigo valor eh
		 o que eu esperava. Com o metodo replace nenhuma chave sera adicionada ao mapa, apenas o valor sera substituido se a chave existir
		 */
		map.replace("brancos", new Person("Substituido", 99));
		map.replace("negros", new Person("Jorge", 25), new Person("substituido conferindo valor", 99));
		map.forEach((key, value) -> System.out.println(key + " " + value));
		
		System.out.println("");
		/*
		 * metodo replaceAll: recebe uma BiFunction (recebe 2 parametros diferentes e retorna um terceiro) como parametro
		 */
		map.replaceAll((key, value) -> new Person("replace all in action", 99));
		
		map.forEach((key, value) -> System.out.println(key + " " + value));
		
		System.out.println("");
		/*
		 metodo remove(key, expectedValue) : remove apenas se a chave estiver associada ao valor esperado
		 */
		map.remove("brancos");
		map.remove("negros", new Person("replace all in action", 99));
		map.remove("vermelhos", new Person("replace all in action", 9));
		
		map.forEach((key, value) -> System.out.println(key + " " + value));
	}
	
}
