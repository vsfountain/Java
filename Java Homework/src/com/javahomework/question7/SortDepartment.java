package com.javahomework.question7;

import java.util.Comparator;

public class SortDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.department.compareTo(o2.department);
	}

}
