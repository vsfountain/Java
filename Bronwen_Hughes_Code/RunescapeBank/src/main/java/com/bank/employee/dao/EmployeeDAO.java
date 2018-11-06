package com.bank.employee.dao;

import java.util.List;

import com.bank.employee.model.Employee;

public interface EmployeeDAO {
	
	public int createEmployeeDB();
	
	public int insertEmployee(Employee e);
	
	public List<Employee> selectAllEmployees();
	public Employee selectEmployeeById(int id);
	public Employee selectEmployeeByUsername (String username);
	//public List<Employee> selectBy
	
	public int updateEmployee(Employee e);
	
	public int deleteEmployee(Employee e);
}
