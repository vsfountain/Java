package com.hw1.q07;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		/*
		 * Question text
		 * 
		 * Q7. Sort two employees based on their name, 
		 * department, and age using the Comparator interface.
		 * 
		 */
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Brittany", "Trust & Investments", 29));
		employees.add(new Employee("Sam", "Corporate Security", 26));
		

		
		System.out.println("Before sort: ");
		for (Employee e: employees) {
			e.printEmployee();
		}
		
		//sort employees
		EmployeeComparator egc = new EmployeeComparator();
		Collections.sort(employees, egc);
		
		System.out.println("After sort: ");
		for (Employee e: employees) {
			e.printEmployee();
		}
	}

}
