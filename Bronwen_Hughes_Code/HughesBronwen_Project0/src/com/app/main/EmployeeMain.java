package com.app.main;

import java.net.PasswordAuthentication;

import com.app.account.Employee;
import com.app.account.EmployeeList;
import com.app.account.LoginEmployee;

public class EmployeeMain {

	private String username;
	private String password;

	private String firstName;
	private String lastName;

	private boolean admin;
	
	public EmployeeMain() {
		chooseAction();
	}

	void chooseAction() {
		while (true) {
			System.out.println("[A] Login [B] Register");
			String temp = ScannerSingleton.instance().next().toUpperCase();
			switch (temp) {
			case "A":
				new LoginEmployee();
				break;
			case "B":
				signUp();
				break;
			default:
				System.out.println("try again!");
			}
		}
	}

	void signUp() {

		System.out.println("Username: ");
		username = ScannerSingleton.instance().next();

		while (true) {
			System.out.println("Password: ");
			String password1 = ScannerSingleton.instance().next();

			System.out.println("Enter Password Again: ");
			String password2 = ScannerSingleton.instance().next();

			if (password1.equals(password2)) {
				password = password1;
				break;
			}
		}
		System.out.println("First Name: ");
		firstName = ScannerSingleton.instance().next();

		System.out.println("Last Name: ");
		lastName = ScannerSingleton.instance().next();

		loop();
		
		Employee employee = new Employee(username, password, firstName, lastName, admin);
		EmployeeList.getInstance().addEmployee(employee);

	}
	
	void loop() {
		System.out.println("Admin? (Y/N): ");

		String temp = ScannerSingleton.instance().next().toUpperCase();
		switch (temp) {
		case "Y":
			admin = true;
			break;
		case "N":
			admin = false;
			break;
		default:
			loop();
		}
	}
}
