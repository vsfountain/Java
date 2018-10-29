package com.homework.problemseven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		
		
		// Creates and adds 2 instances of the Employee class
		employees.add(new Employee("Mason", "IT", 26));
		employees.add(new Employee("Jesse", "HR", 37));
		
		EmployeeNameComparator enc = new EmployeeNameComparator();
		EmployeeDepartmentComparator edc = new EmployeeDepartmentComparator();
		EmployeeAgeComparator eac = new EmployeeAgeComparator();
		Collections.sort(employees, enc);
		System.out.println("Employees sorted by name: " + employees);
		Collections.sort(employees, edc);
		System.out.println("Employees sorted by department: " + employees);
		Collections.sort(employees, eac);
		System.out.println("Employees sorted by age: " + employees);

	}

}
