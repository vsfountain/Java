package com.example.sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver{

	public static void main(String[] args) {
		List<Student> students= new ArrayList<>();
		
		/*list.add("dog");
		list.add("cheetos");
		list.add("potatoe");
		list.add("Kristen");
		list.add("pickle rick");
		list.add("Divinci");*/
		students.add(new Student(3, "John", 3.5, LocalDate.of(1970, 2, 12)));
		students.add(new Student(17, "Amy", 3.1, LocalDate.of(1989, 1, 15)));
		students.add(new Student(1, "Austin", 4.0, LocalDate.of(1971, 3, 30)));
		students.add(new Student(2, "Katie", 2.9, LocalDate.of(1776, 12, 02)));
		students.add(new Student(4, "Courtney", 3.0, LocalDate.of(1004, 7, 12)));
		
		//System.out.println("This is my list: "+students);
		
		//Collections is a utility class, filled with static methods
		//		useful for operations on the collection api
		Collections.sort(students);
		System.out.println("This is my sorted id list: "+students);
		
		StudentGpaComparator sgc= new StudentGpaComparator();
		Collections.sort(students, sgc);
		System.out.println("This is my sorted gpa list: "+students);
	}

}
