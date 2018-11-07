package com.app.main;

import java.util.Scanner;

import com.app.account.CustomerList;
import com.app.account.LoginEmployee;

public class Main {

	public static boolean running = true;

	public static void main(String[] args) {
		// ask for employee login or customer login

		// if employee login, prompt company login details
		// if okay, then allow access

		// if customer logisn, prompt customer login details
		// if no account, prompt create a new account

		start();
	}
	
	public static void start() {
		while (running) {
			System.out.println("Are you an employee or a customer? (Employee / Customer)");
			String temp = ScannerSingleton.instance().nextLine().toUpperCase();

			if (temp.equals("EMPLOYEE")) {
				// start employee application
				new EmployeeMain();
				break;
			} else if (temp.equals("CUSTOMER")) {
				// start customer
				new CustomerMain();
				break;
			} else if (temp.equals("EXIT")) {
				exitApplication();
				break;
			} else {
				System.out.println("Invalid");
			}
		}
	}
	
	
	public static void exitApplication() {
		System.out.println("Exiting program!");
		System.exit(0);
	}

}
