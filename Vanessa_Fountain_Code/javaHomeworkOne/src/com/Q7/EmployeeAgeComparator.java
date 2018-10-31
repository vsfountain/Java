package com.Q7;
import java.time.LocalDate;
import java.util.Comparator;
/*
 * Sort two employees based on their 
 * name, department, and age 
 * using the Comparator interface.
 */
public class EmployeeAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		LocalDate o1age= o1.getDob();
		LocalDate o2age= o2.getDob();
		
		if(o1age.isAfter(o2age)) {
			return 1;
		}else if(o1age.isBefore(o2age)) {
			return -1;
		}else {
			return 0;
		}
	}
	

	

}
