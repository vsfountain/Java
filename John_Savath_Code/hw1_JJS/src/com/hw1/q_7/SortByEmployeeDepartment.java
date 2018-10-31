package com.hw1.q_7;

import java.util.Comparator;

public class SortByEmployeeDepartment implements Comparator<Employee> {
	
	//Sort by ascending order by department for employee
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.department.compareTo(o2.department);
	}

}
