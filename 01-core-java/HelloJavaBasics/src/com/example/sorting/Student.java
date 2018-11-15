package com.example.sorting;

import java.time.LocalDate;

//Comparable is a functional interface
//		a functional interface is an interface with a single method in it,
//		nothing else
//Comparable is created within the object's class itself
//Comparable's compareTo() method defines the NATURAL ordering of the class
public class Student implements Comparable<Student>{

	private int studentId;
	private String name;
	private double gpa;
	private LocalDate dob;
	
	public Student() {
	}

	public Student(int studentId, String name, double gpa, LocalDate dob) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gpa = gpa;
		this.dob = dob;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "\n\tStudent [studentId=" + studentId + ", name=" + name + ", gpa=" + gpa + ", dob=" + dob + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.getStudentId()-o.getStudentId();
	}
	
}
