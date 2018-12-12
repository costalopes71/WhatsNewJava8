package com.pluralsight.whtasnewonjava8.filefilter.impl;

import java.io.File;
import java.io.FileFilter;

import com.pluralsight.whtasnewonjava8.filefilter.JavaFileFilter;

public class ListDirectoriesImpl {

	public static void main(String[] args) {
		
		JavaFileFilter fileFilter = new JavaFileFilter();
		File dir = new File("F:\\workspaces\\Pluralsight_workspaces\\Generics_workspace\\GenericsStudies\\src\\com\\pluralsight\\generics\\class_literals");
		File[] javaFiles = dir.listFiles(fileFilter);
		
		System.out.println(javaFiles.length);
		
		// implementando a interface FileFilter com uma classe anonima
		
		FileFilter fileFilterAnon = new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.getName().endsWith(".java");
			}
		};
		
		File[] javaFiles2 = dir.listFiles(fileFilterAnon);
		
		for (File file : javaFiles2) {
			System.out.println(file.getName());
		}
		
	}
	
}