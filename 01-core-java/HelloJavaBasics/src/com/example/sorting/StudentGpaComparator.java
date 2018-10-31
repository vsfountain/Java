package com.example.sorting;

import java.util.Comparator;

//Comparator is a functional interface
//		a functional interface is an interface with a single method in it,
//		nothing else
//Comparator is created external to the object's class; it's own class
//Comparator's compare() method defines the UNNATURAL ordering of the class
public class StudentGpaComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		double o1Gpa= o1.getGpa();
		double o2Gpa= o2.getGpa();
		
		if(o1Gpa>o2Gpa) {
			return 1;
		}else if(o1Gpa<o2Gpa) {
			return -1;
		}else {
			return 0;
		}
	}

}
