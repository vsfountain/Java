package com.homework.question7;

import java.util.ArrayList;
import java.util.Collections;

public class MainEmployees {
	public static void main(String[] args) {
		ArrayList<Employees> myList = new ArrayList<>();
		
		myList.add(new Employees("Bob", "Computer Science", 32));
		myList.add(new Employees("Jim", "Psychology", 26));
		
		EmployeesComparator comparePeeps = new EmployeesComparator();
		Collections.sort(myList, comparePeeps);
		System.out.println("Printing in order of age: " + myList);
		
		EmployeesNameComparator compareNames = new EmployeesNameComparator();
		Collections.sort(myList, compareNames);
		System.out.println("Printing in order of names: " + myList);
		
		EmployeesDepartmentComparator compareDepartments = new EmployeesDepartmentComparator();
		Collections.sort(myList, compareDepartments);
		System.out.println("Printing in order of departments: " + myList);
	}
}
