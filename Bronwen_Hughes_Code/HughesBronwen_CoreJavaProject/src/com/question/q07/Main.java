package com.question.q07;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		
		Employee e1 = new Employee("Kat", "Gaming and Animation", 23);
		Employee e2 = new Employee("Michael", "Computer Science", 25);
		
		ArrayList<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(e1);
		employeeList.add(e2);
		
		NameComparator nameComparator = new NameComparator();
		Collections.sort(employeeList, nameComparator);
		System.out.println("Employees in order by name: \n" + employeeList);
		
		DepartmentComparator depComparator = new DepartmentComparator();
		Collections.sort(employeeList, depComparator);
		System.out.println("Employees in order by department: \n" + employeeList);
		
		AgeComparator ageComparator = new AgeComparator();
		Collections.sort(employeeList, ageComparator);
		System.out.println("Employees in order by age: \n" + employeeList);
	}
}
