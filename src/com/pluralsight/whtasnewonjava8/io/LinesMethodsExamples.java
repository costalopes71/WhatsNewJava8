package com.pluralsight.whtasnewonjava8.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LinesMethodsExamples {

	// Um metodo lines() foi adicionado a classe BufferedReader e devolve um Stream
	public static void main(String[] args) {
		
		try (BufferedReader reader = 
				new BufferedReader(
				new FileReader(
				new File("F:\\workspaces\\Sinapsis_workspaces\\ConversorMedicoes_workspace\\conversormedicoes\\ConversorMedicoes\\logs\\conversormedicoes.log")));
			) {
			
			Stream<String> stream = reader.lines();
			stream.filter(line -> line.contains("INFO")).
				findFirst().
				ifPresent(System.out::println);
//				forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------------------------------------------------------");
		
		//Simplificando mais ainda usando Path e usando o metodo lines que foi adicionado na classe Files
		Path path = Paths.get("F:", "workspaces", "Sinapsis_workspaces", "ConversorMedicoes_workspace", "conversormedicoes", "ConversorMedicoes", "logs", "2018-01", "app-01-31-2018-1.log");
		try (Stream<String> stream = Files.lines(path)) {
			
			stream.filter(line -> line.contains("TRACE")).
				findFirst().
				ifPresent(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}