package com.pluralsight.whtasnewonjava8.firstLambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		String tmp = System.getProperty("java.io.tmpdir");
		File dir = new File("C:/");
		FileFilter filter = (File file) -> file.getAbsolutePath().contains("a");
		
		File[] filesArray = dir.listFiles(filter);
		
		System.out.println(filesArray.length);

		for (File file : filesArray) {
			System.out.println(file.getName());
		}
		
		// lambda with type inferance
		FileFilter filterInferenced = (file) -> file.getName().contains(".");
		File[] listFiles3 = dir.listFiles(filterInferenced);
		
		System.out.println("Lambda com type inference");
		for (File file : listFiles3) {
			System.out.println(file.getName());
		}
		
	}
	
}