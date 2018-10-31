package com.Q7;

import java.util.Comparator;

public class EmployeeDeptComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		String o1dept= o1.getDept();
		String o2dept= o2.getDept();
		
		return o1dept.compareTo(o2dept);
		}
}
