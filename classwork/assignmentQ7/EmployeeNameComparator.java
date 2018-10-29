package com.assignmentQ7;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {		
		String e1Name = e1.getName();
		String e2Name = e2.getName();
		
		if(e1Name.compareTo(e2Name) > 0) {
			return 1;
		}
		else if(e1Name.compareTo(e2Name)<0){
			return -1;
		}
		else {
			return 0;
		}
	}
}
