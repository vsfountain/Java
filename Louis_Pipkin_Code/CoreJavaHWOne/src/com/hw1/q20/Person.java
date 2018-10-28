package com.hw1.q20;

public class Person {
	public String fName;
	public String lName;
	public int age;
	public String state;
	
	Person(String fName, String lName, int age, String state){
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.state = state;
	}
	
	public void printPerson() {
		//Name: Mickey Mouse
		System.out.println("Name: "+this.fName+" "+this.lName);
		//Age: 35 years
		System.out.println("Age: "+this.age+" years");
		//State: Arizona State
		System.out.println("State: "+this.state+" State");
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", age=" + age + ", state=" + state + "]";
	}
}
