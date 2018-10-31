package com.example.sortemployees;

import java.util.Comparator;

import com.example.sortemployees.SortEmployees.Employee;

public class NameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		
		return o1.name.compareTo(o2.name);
	}

}

class DepartmentComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}
	
	
}

class AgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if(o1.age < o2.age) {
			return -1;
		}
		if(o1.age > o2.age) {
			return 1;
		}
		return 0;
	}
	
}