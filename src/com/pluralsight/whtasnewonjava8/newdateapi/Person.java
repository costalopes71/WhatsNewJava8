package com.pluralsight.whtasnewonjava8.newdateapi;

import java.time.LocalDate;

public class Person {

	private String name;
	private LocalDate dathOfBith;

	public Person() { }
	
	public Person(String name, LocalDate dathOfBith) {
		this.name = name;
		this.dathOfBith = dathOfBith;
	}

	public String getName() {
		return name;
	}
	
	public LocalDate getDathOfBith() {
		return dathOfBith;
	}

	@Override
	public String toString() {
		return "Person{name: " + this.name + " date of birth: " + this.dathOfBith + "}";
	}
	
}
