package com.assignmentQ7;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		int e1Age = e1.getAge();
		int e2Age = e2.getAge();
		if(e1Age>e2Age) {
			return 1;
		}
		else if(e1Age<e2Age){
			return -1;
		}
		else {
			return 0;
		}
	}
	
}
