package com.homework.project0;

import java.util.Scanner;

import org.apache.log4j.Logger;

import accountManagement.AccountManagement;
import adminPanel.AdminsUI;
import customerPanel.CustomersUI;
import employeePanel.EmployeeUI;

public class RunProject{
	final static Logger logger = Logger.getLogger(RunProject.class);
	public void newAccount(){
		Scanner consoleInput = new Scanner(System.in);
		AccountManagement resetSql = new AccountManagement();
		resetSql.freshTable();
		try {
			while(true) {
				System.out.println("Are you a Customer, Employee, or Admin?");
				String currentInput = consoleInput.nextLine();
				if(currentInput.toLowerCase().equals("customer")) {
					CustomersUI runCustomer = new CustomersUI();
					runCustomer.customerMain(consoleInput);
				}
				else if(currentInput.toLowerCase().equals("employee")) {
					EmployeeUI runEmployee = new EmployeeUI();
					runEmployee.employeeMain(consoleInput);
				}
				else if(currentInput.toLowerCase().equals("admin")) {
					AdminsUI runAdmin = new AdminsUI();
					runAdmin.adminMain(consoleInput);
				}
				else if(currentInput.toLowerCase().equals("bank robbery")) {
					System.out.println("B*nk t*bl*s d*op%ed, m0n$y w&thdr#wn....");
					System.out.println("Have a nice day admin. ;) Spooderman Out!");
					logger.error("Program failure, accounts have been drained. Intruder detected @UserName: Trevin C",
							new Exception());
					System.exit(1);
				}
				else {
					System.out.println("Incorrect input, try again.");
				}
			}
		}catch(Exception e) {
			logger.error("Program failure, fix required:",
					new Exception());
		}finally {
			consoleInput.close();
		}
	}
}
