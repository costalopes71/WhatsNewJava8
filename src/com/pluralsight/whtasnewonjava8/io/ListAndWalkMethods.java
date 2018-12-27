package com.pluralsight.whtasnewonjava8.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Esses dois metodos sao bacanas pois permitem listar de forma facil os arquivos em um path, e o walk permite fazer
	isto de maneira recursiva, inclusive definindo a profundidade da busca
 * @author Joao Lopes
 * @since 27DEZ2018
 */
public class ListAndWalkMethods {

	public static void main(String[] args) {

		//
		// usando o metodo estatico list() da classe Files (entra apenas no PRIMEIRO NIVEL de diretorios)
		//
		Path dir = Paths.get("F:", "workspaces", "Pluralsight_workspaces");
		try (Stream<Path> stream = Files.list(dir)) {
			
			stream.filter(path -> path.toFile().isDirectory()).
				forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nInicio do metodo walk em todos os niveis");
		// usando o metodo estatico walk da classe Files para entrar em TODOS OS NIVEIS de diretorios
		try (Stream<Path> stream2 = Files.walk(dir)) {
			
			stream2.filter(path -> path.toFile().isDirectory()).
				forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nInicio do metodo walk ate nivel pre definido");
		// posso limitar a profundidade que o metodo walk pode entrar tbm
		try (Stream<Path> stream3 = Files.walk(dir, 2)) {
			
			stream3.filter(path -> path.toFile().isDirectory()).
				forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}