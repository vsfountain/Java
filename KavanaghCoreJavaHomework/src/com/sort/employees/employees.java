package com.sort.employees;

public class employees {
	private String name;
	private String department;
	private int age;

	public employees(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;

	}

// getters and setters

public String toString() {
    return new String ("\t" + name + "\t"+ department + age);//String.format("\t", name, department, age);
}

public String getName() {
	// TODO Auto-generated method stub
	return this.name;
}
public int getAge() {
	return this.age;
}
public String getDepartment() {
	return this.department;
}
}
