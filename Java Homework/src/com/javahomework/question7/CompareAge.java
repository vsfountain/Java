package com.javahomework.question7;


import java.util.Comparator;

class CompareAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.age - o2.age;
	}
}
