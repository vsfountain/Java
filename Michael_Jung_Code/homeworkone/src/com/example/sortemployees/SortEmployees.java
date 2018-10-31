package com.example.sortemployees;

import java.util.ArrayList;
import java.util.Collections;

public class SortEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Employee a = new Employee("a", "aa", 13);
		Employee b = new Employee("b", "ab", 15);
		ArrayList<Employee> aa = new ArrayList<Employee>();
		
		aa.add(a);
		aa.add(b);
		
		NameComparator aaa = new NameComparator();
		Collections.sort(aa, aaa);
		for(Employee aaaa: aa) {
			System.out.println(aaaa.name + " " +
							   aaaa.department + " " + 
							   aaaa.age);
		}
		
		DepartmentComparator aaaa = new DepartmentComparator();
		Collections.sort(aa, aaaa);
		for(Employee aaaaa: aa) {
			System.out.println(aaaaa.name + " " + 
							   aaaaa.department + " " + 
							   aaaaa.age);
		}
		
		AgeComparator aaaaa = new AgeComparator();
		Collections.sort(aa, aaaaa);
		for(Employee aaaaaa: aa) {
			System.out.println(aaaaaa.name + " " +
							   aaaaaa.department + " " + 
							   aaaaaa.age);
		}
		
	}
	
	public static class Employee {
		
		String name;
		String department;
		int age;
		
		
		public Employee(String name, String department, int age) {
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		
		
		
		
	}

}

