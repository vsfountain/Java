
package com.app.account;

import com.app.company.CompanyView;
import com.app.main.Main;
import com.app.main.ScannerSingleton;

public class LoginEmployee {

	private boolean loggedIn;
	private Employee employee;

	public LoginEmployee() {
		attemptLogin();
	}
	
	public LoginEmployee(String username, String password) {
		checkCredentials(username, password);
		if (loggedIn) {
			new CompanyView(employee);
		}
	}

	
	public void checkCredentials(String username, String password) {
		for(Employee employee : EmployeeList.getInstance().employeeList) {
			if(employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
				loggedIn = true;
				this.employee = employee;
				break;
			}
		}
		if(!loggedIn)
		{
			System.out.println("You have enterd the wrong username and password. Please try again!");
			trySwitch();
		}
	}

	

	public void trySwitch() {
		System.out.println("[A] Try Again [B] Back");

		String temp = ScannerSingleton.instance().next().toUpperCase();
		switch (temp) {
		case "A":
			attemptLogin();
			break;
		case "B":
			Main.start();
			break;
		default:
			trySwitch();
		}
	}

	public void attemptLogin() {
		System.out.println("Enter your username: ");
		String username = ScannerSingleton.instance().next();

		System.out.println("Enter your password: ");
		String password = ScannerSingleton.instance().next();

		new LoginEmployee(username, password);
	}
}
