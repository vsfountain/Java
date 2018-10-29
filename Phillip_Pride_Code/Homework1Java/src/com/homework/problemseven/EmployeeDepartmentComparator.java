package com.homework.problemseven;
import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getDept().compareTo(o2.getDept())<0) {
			return -1;
		}else if(o1.getDept().compareTo(o2.getDept())>0) {
			return 1;
		}else
		return 0;
	}

}
