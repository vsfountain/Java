package com.hw1.q_7;

import java.util.ArrayList;
import java.util.Collections;

//Q7. Sort two employees based on their name, department, and age 
//using the Comparator interface.

public class Main {

	public static void main(String[] args) {
		ArrayList<Employee> e1 = new ArrayList<Employee>();//Create array list to add a list of employees in
		e1.add(new Employee("John", "Sales", 33));//added john
		e1.add(new Employee("Clement", "Education", 25));//added clement
		e1.add(new Employee("Sarah", "Marketing", 19));//added Sarah
		
		System.out.println("Unsorted List:"); 
        for (int i=0; i<e1.size(); i++) 
            System.out.println(e1.get(i)); 
        
        //Sorting the array list of employees by name
        Collections.sort(e1, new SortByEmployeeName()); 
  
        System.out.println("\nSorted by Name:"); 
        for (int i=0; i<e1.size(); i++) 
            System.out.println(e1.get(i)); 
        
        
      //Sorting the array list of employees by name
        Collections.sort(e1, new SortByEmployeeDepartment()); 
  
        System.out.println("\nSorted by Department:"); 
        for (int i=0; i<e1.size(); i++) 
            System.out.println(e1.get(i)); 
        
      //Sorting the array list of employees by name
        Collections.sort(e1, new SortByEmployeeAge()); 
        
        System.out.println("\nSorted by Age:"); 
        for (int i=0; i<e1.size(); i++) 
            System.out.println(e1.get(i)); 
	}

}
