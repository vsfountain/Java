package com.Q7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverFile {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee("Math", "Daniel", LocalDate.of(1970, 2, 12)));
		employees.add(new Employee("English", "Jess", LocalDate.of(1989, 1, 15)));
		
		Collections.sort(employees);
		System.out.println("Sorted by Name: "+employees);
		
		EmployeeAgeComparator age= new EmployeeAgeComparator();
		Collections.sort(employees, age);
		System.out.println("Sorted by Age: "+employees);
		
		EmployeeDeptComparator dept= new EmployeeDeptComparator();
		Collections.sort(employees, dept);
		System.out.println("Sorted by Department: "+employees);
		
	}

}
