package com.homework.project0;

import java.util.Scanner;

import adminPanel.AdminsUI;
import adminPanel.AdminsUIDao;
import customerPanel.CustomersUI;
import customerPanel.CustomersUIDao;
import employeePanel.EmployeeUI;
import employeePanel.EmployeeUIDao;

public class RunProject implements RunProjectDao{
	@Override
	public void newAccount(){
		Scanner consoleInput = new Scanner(System.in);
		try {
			while(true) {
				System.out.println("Are you a Customer, Employee, or Admin?");
				String currentInput = consoleInput.nextLine();
				if(currentInput.toLowerCase().equals("customer")) {
					CustomersUIDao runCustomer = new CustomersUI();
					runCustomer.customerMain(consoleInput);
					//CustomersUI.customerMain(consoleInput);
				}
				else if(currentInput.toLowerCase().equals("employee")) {
					//EmployeeUI.employeeMain(consoleInput);
					EmployeeUIDao runEmployee = new EmployeeUI();
					runEmployee.employeeMain(consoleInput);
				}
				else if(currentInput.toLowerCase().equals("admin")) {
					//AdminsUI.adminMain(consoleInput);
					AdminsUIDao runAdmin = new AdminsUI();
					runAdmin.adminMain(consoleInput);
				}
				else {
					System.out.println("Incorrect input, try again.");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			consoleInput.close();
		}
	}
}
