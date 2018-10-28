package com.hw1.q07;

public class Employee implements Comparable<Employee> {
	
	String name;
	String department;
	int age;
	
	Employee(String name, String dep, int age) {
		this.name = name;
		this.department = dep;
		this.age = age;
	}
	
	public void printEmployee() {
		//remember toString()!
		System.out.println("\t"+this.name+", "+this.department+", "+this.age);
		//System.out.println("\t"+this.department);
		//System.out.println("\t"+this.age);
	}
	
	public int compareTo(Employee other) {
		//sorts by name
		return this.name.compareToIgnoreCase(other.name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
