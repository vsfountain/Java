package com.bank.employee.service;

import java.util.List;

import com.bank.employee.dao.EmployeeDAO;
import com.bank.employee.dao.EmployeeDAOImpl;
import com.bank.employee.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.selectAllEmployees();
	}

	@Override
	public int createEmployeeDB() {
		employeeDAO.createEmployeeDB();
		return 0;
	}

	@Override
	public int addEmployee(Employee employee) {
		employeeDAO.insertEmployee(employee);
		return 0;
	}

	@Override
	public Employee getEmployeeFromUsername(String username) {
		return employeeDAO.selectEmployeeByUsername(username);	
	}

}
