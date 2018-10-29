package com.assignmentQ7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John","Sewage" , 35));
		employees.add(new Employee("Amy", "Math", 31));
		employees.add(new Employee("Justin", "HR", 40));
		employees.add(new Employee("Katie", "Reception", 29));
		employees.add(new Employee("Courtney", "Pharmacy", 30));		
		
		EmployeeNameComparator enc = new EmployeeNameComparator();
		Collections.sort(employees, enc);
		System.out.println("This is the list sorted by name: " + employees);
		
		EmployeeDepartmentComparator edc = new EmployeeDepartmentComparator();
		Collections.sort(employees, edc);
		System.out.println("This is my list sorted by department: " + employees);			
				
		EmployeeAgeComparator eac = new EmployeeAgeComparator();
		Collections.sort(employees, eac);
		System.out.println("This is my list sorted by age: " + employees);
	}
}
