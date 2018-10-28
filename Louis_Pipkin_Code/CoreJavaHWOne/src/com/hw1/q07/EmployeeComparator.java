package com.hw1.q07;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{
	
	public int compare(Employee one, Employee two) {
		//sorts by department, then name, then age. 
		if (one.department.compareToIgnoreCase(two.department) > 0) {
			return 1;
		}else if (one.department.compareToIgnoreCase(two.department) < 0){
			return -1;
		}else {
			if (one.name.compareToIgnoreCase(two.name) > 0) {
				return 1;
			}else if (one.name.compareToIgnoreCase(two.name) < 0){
				return -1;
			}else {
				if (one.age > two.age) {
					return 1;
				}else if (one.age < two.age){
					return -1;
				}else {
					return 0;
				}
			}
		}
	  }

}
