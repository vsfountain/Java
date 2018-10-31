package com.question.q07;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		
		char o1char = o1.getName().toCharArray()[0];
		char o2char =  o2.getName().toCharArray()[0];
		
		if(o1char > o2char) {
			return 1;
		} else if ( o1char < o2char) {
			return -1;
		} else {
			return 0;
		}
	}

}
