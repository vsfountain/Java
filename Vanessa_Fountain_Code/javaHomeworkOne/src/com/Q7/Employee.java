package com.Q7;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>{
	private int employeeId;
	private String dept;
	private String name;
	private LocalDate dob;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Employee(String dept, String name, LocalDate dob) {
		super();
		this.dept = dept;
		this.name = name;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [dept=" + dept + ", name=" + name + ", dob=" + dob + "]";
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.getEmployeeId()-o.getEmployeeId();
	}
	
	
}
