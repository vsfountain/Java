package com.homework.question7;

import java.util.Comparator;

public class EmployeesDepartmentComparator implements Comparator<Employees> {
	
	@Override
	public int compare(Employees o1, Employees o2) {
		String personOne = o1.getDepartment();
		String personTwo = o2.getDepartment();
		char[] personOneArr = personOne.toCharArray();
		char[] personTwoArr = personTwo.toCharArray();
		if(personOneArr[0] > personTwoArr[0]) {
			return 1;
		}else if(personOneArr[0] < personTwoArr[0]){
			return -1;
		}else {
			return 0;
		}
	}
}
