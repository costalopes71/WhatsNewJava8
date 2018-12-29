package com.pluralsight.whtasnewonjava8.lambdaandstream.model;

public class Person {

	private String name;
	
	private String lastName;
	
	private int age;

	public Person() { }
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, String lastName) {
		this.name = name;
		this.age = age;
		this.lastName = lastName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [" + this.name + ", " + this.age + "]";
	}
	
}