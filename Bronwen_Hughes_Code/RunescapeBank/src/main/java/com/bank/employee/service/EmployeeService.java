package com.bank.employee.service;

import java.util.List;

import com.bank.employee.model.Employee;

public interface EmployeeService {
	public int createEmployeeDB();
	public int addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeFromUsername(String username);
}
