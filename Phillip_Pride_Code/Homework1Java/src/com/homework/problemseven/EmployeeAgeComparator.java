package com.homework.problemseven;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int o1Age = o1.getAge();
		int o2Age = o2.getAge();

		if (o1Age > o2Age) {
			return 1;
		} else if (o2Age > o1Age) {
			return -1;
		} else {
			return 0;
		}
	}

}
