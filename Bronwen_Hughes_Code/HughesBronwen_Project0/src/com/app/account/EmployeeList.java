package com.app.account;

import java.util.ArrayList;

public class EmployeeList {

	private static EmployeeList instance;
	public ArrayList<Employee> employeeList = new ArrayList<>();

	private EmployeeList() {
	}

	public static EmployeeList getInstance() {
		if (instance == null) {
			instance = new EmployeeList();
		}
		return instance;
	}

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	@Override
	public String toString() {
		return "EmployeeList [employeeList=" + employeeList + "]";
	}

}
