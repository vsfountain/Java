package com.question.q07;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		int o1int = o1.getAge();
		int o2int =  o2.getAge();
		
		if(o1int > o2int) {
			return 1;
		} else if ( o1int < o2int) {
			return -1;
		} else {
			return 0;
		}
	}

}
