package com.hw1.q_7;

import java.util.Comparator;

public class SortByEmployeeName implements Comparator<Employee> {
	
	//Sort by ascending order by name
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}

}
