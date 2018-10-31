/**
 * 
 */
package com.hw1.q_7;

import java.util.Comparator;

/**
 * @author JohnJosephSavath
 *
 */
public class Employee{
	
	//Initialize the variables for Employees
	int age;
	String name, department;
	
	//Constructor for Employee
	public Employee (String name, String department,int age) {
		
		this.name = name;
		this.department = department;
		this.age = age;
		
	}
	
	//Print out the values in main()
	public String toString() {
		return this.name + " " + this.department + " " + this.age;
	}

}
