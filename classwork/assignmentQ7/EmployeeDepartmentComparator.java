package com.assignmentQ7;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee> {
	
	@Override
	public int compare(Employee d1, Employee d2) {
		/*double o1Gpa = o1.getGpa();
		double o2Gpa = o2.getGpa();*/
		String d1Dep = d1.getDept();
		String d2Dep = d2.getDept();
		
		if(d1Dep.compareTo(d2Dep) > 0) {
			return 1;
		}
		else if(d1Dep.compareTo(d2Dep)<0){
			return -1;
		}
		else {
			return 0;
		}
	}
}
