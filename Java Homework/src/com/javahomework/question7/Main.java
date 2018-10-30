package com.javahomework.question7;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
	
	public static void main(String [] args) {
		// TODO Auto-generated constructor stub
		ArrayList<Employee> myList = new ArrayList<Employee>();
		myList.add(new Employee("Clement", "Information Techonology", 24));
		myList.add(new Employee("John", "Game Design", 33));
		myList.add(new Employee("Alex", "Sales", 22));
		
		
		Collections.sort(myList, new SortName());
		System.out.println("Sorted by Name - ");
		for(Employee i : myList) {
		System.out.println("Employee's Name : " + i.name);
		}
		
		Collections.sort(myList, new SortDepartment());
		System.out.println("\nSorted by Department - ");
		for(Employee i : myList) {
		System.out.println(i.name + "'s Department : " + i.department);
		}
		
		Collections.sort(myList, new CompareAge());
		System.out.println("\nSorted by Age - ");
		for(Employee i : myList) {
		System.out.println(i.name +"'s Age is: " + i.age);
		
		}
		
		
		
	}
}
