package com.homework.question7;

import java.util.Comparator;

public class EmployeesNameComparator implements Comparator<Employees>{

	@Override
	public int compare(Employees o1, Employees o2) {
		String personOne = o1.getName();
		String personTwo = o2.getName();
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
