package com.corejava.question7;

/*Sort two employees based on their name, department, and age using the
Comparator interface.*/

public class Employee {

	String name;
	String department;
	int age;

	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	String getName() {
		return this.name;
	}

	String getDepartment() {
		return this.department;
	}

	int getAge() {
		return this.age;
	}

	public String toString() {
		return this.name + " " + this.department + 
					       " " + this.age;
	}

}
