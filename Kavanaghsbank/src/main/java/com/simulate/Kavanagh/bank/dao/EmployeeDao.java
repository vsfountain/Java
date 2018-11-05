package com.simulate.Kavanagh.bank.dao;

import java.util.List;

import com.simulate.Kavanagh.bank.model.Employee;

/**
 * @author Kristen Kavanagh
 * @version 11/5/2018
 *
 */
public interface EmployeeDao {

	/**
	 * 
	 */
	public int insertEmployeeDao(Employee e);
	 //read
	public List<Employee>selectAllEmployee();
	public Employee selectEmployeebyId (int employee_id);
	public List<Employee>selectAllEmployeebyEmpFirstName(String empFristName);
	public List<Employee>selectAllEmployeebyEmpLastName(String empLastName);
	public List <Employee>selectAllEmployeebyJobtitle(String jobtitle);
	public Employee selectEmployeebyJobTitle();
	public Employee selectEmployeebyFirstName();
	public Employee selectEmployeebyLastName();
	//update 
	public int updateEmployee (Employee e);
	//Delete
	public int deleteEmployee(Employee e);

	
	
}
