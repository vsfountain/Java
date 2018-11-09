package com.example.service;

import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoImpl;
import com.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDao employee = new EmployeeDaoImpl();
	
	
	
	@Override
	public String getEmployeeName(String name) {
		// TODO Auto-generated method stub
		
		Employee e = employee.selectEmployeeByName(name);
		
		if(e == null) {
			return "";
		}
		String employeeName = e.getUsername();
		
		return employeeName;
		
		
		//return null;
	}

	
	
	
	
	
}
 