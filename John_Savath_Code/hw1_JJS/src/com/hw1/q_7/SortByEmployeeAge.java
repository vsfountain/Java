package com.hw1.q_7;

import java.util.Comparator;

public class SortByEmployeeAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.age - o2.age;
	}

}
