package com.simulate.Kavanagh.bank.service;

import java.util.List;

import com.simulate.Kavanagh.bank.dao.EmployeeDao;
import com.simulate.Kavanagh.bank.dao.EmployeeDaoImpl;
import com.simulate.Kavanagh.bank.model.Employee;

/**
 * @author Kristen Kavanagh
 * @version 11/6/2018
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employee = new EmployeeDaoImpl();

	@Override
	public List<Employee> getAllEmployee() {
		// put any other business logic here
		return employee.selectAllEmployee();
	}
	/**
	 * Employees can view account information
	 */
//	public String accountInformation() {
//		return (client.userName + client.passWord);
//	}
//
//	/**
//	 * Employees can view balance
//	 */
////	public double accountBalance() {
////		return balance.getBalance();
////
////	}
//
//	/**
//	 * Employees views customer's personal information
//	 */
////	public String personalInformation() {
////		return client.name;
////
////	}
//
//	/*
//	 * employees approve or deny account open applications for accounts
//	 */
////	public void openAccount() {
////		if (balance.getBalance()> 500) {
////			System.out.println("Approved, your account is now open");
////		} else {
////			System.out.println(" Sorry, we are not able to complete your reques");
////		}
////	}
//
}


