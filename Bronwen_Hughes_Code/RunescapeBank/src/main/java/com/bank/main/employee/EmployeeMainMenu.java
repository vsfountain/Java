package com.bank.main.employee;

import com.bank.employee.model.Employee;
import com.bank.employee.service.EmployeeService;
import com.bank.employee.service.EmployeeServiceImpl;
import com.bank.main.ScannerSingleton;

public class EmployeeMainMenu {

	private final String adminPassphrase = "#CAFEBABE";
	EmployeeService employeeService = new EmployeeServiceImpl();

	public EmployeeMainMenu() {
		
		chooseAction();
	}

	void chooseAction() {
		while (true) {
			System.out.println("[A] Login [B] Register");
			String temp = ScannerSingleton.instance().next().toUpperCase();

			switch (temp) {
			case "A":
				attemptLogin();
				break;
			case "B":
				register();
				break;
			default:
				System.out.println("Please enter a valid reponse.");
			}
		}
	}

	public void register() {
		System.out.println("[ Employee Registration ] \n" + "Please fill in the following form: ");
		System.out.print("Enter your desired username: ");
		// ADD CHECK DESIRED USERNAME HERE!
		String username = ScannerSingleton.instance().next();

		String password;
		while (true) {
			System.out.print("Enter your desired Password: ");
			String password1 = ScannerSingleton.instance().next();

			System.out.print("Confirm your password: ");
			String password2 = ScannerSingleton.instance().next();

			if (password1.equals(password2)) {
				password = password1;
				break;
			}
		}

		System.out.print("Enter your first name: ");
		String firstname = ScannerSingleton.instance().next();

		System.out.print("Enter your last name: ");
		String lastname = ScannerSingleton.instance().next();

		boolean admin = adminConfirmation();

		// TODO - CONFIRM DETAILS TO SUBMIT!
		
		// TODO - INCREMENT IN JAVA
		Employee tempEmployee = new Employee(employeeService.getAllEmployees().size() + 1, username, password, firstname, lastname, admin);
		employeeService.addEmployee(tempEmployee);
	}

	boolean adminConfirmation() {
		boolean admin;
		while (true) {
			System.out.println("Are you an admin? [Y / N]");
			String temp = ScannerSingleton.instance().next().toUpperCase();

			switch (temp) {
			case "Y":
				// admin = true;
				System.out.println("A");
				if (adminPassphraseConfirmation()) {
					admin = true;
				} else {
					admin = false;
				}
				return admin;
			case "N":
				admin = false;
				System.out.println("B");
				return admin;
			default:
				System.out.println("Please enter a valid response.");
				break;
			}
		}

	}

	boolean adminPassphraseConfirmation() {
		System.out.println("Please enter the admin passphase: ");
		String temp = ScannerSingleton.instance().next();
		
		switch (temp) {
		case adminPassphrase:
			return true;
		default:
			System.out.println("Admin passphrase is incorrect.");
			while (true) {
				System.out.println("Would you like to try again? [Y/N]");
				temp = ScannerSingleton.instance().next().toUpperCase();

				switch (temp) {
				case "Y":
					adminPassphraseConfirmation();
					break;
				case "N":
					return false;
				default:
					System.out.println("Please enter a valid response.");
					break;
				}
			}
		}

	}

	public void attemptLogin() {
		System.out.println("Please enter your credentials.");
		System.out.print("Username: ");
		String username = ScannerSingleton.instance().next();
		System.out.print("Password: ");
		String password = ScannerSingleton.instance().next();
		
		boolean temp = checkCredentials(username, password);
		if(temp) {
			new EmployeePortal();
		} else if(!temp) {
			while (true) {
				System.out.println("Would you like to try again? [Y/N] ");
				String tempS = ScannerSingleton.instance().next().toUpperCase();

				switch (tempS) {
				case "Y":
					attemptLogin();
					break;
				case "N":
					break;
				default:
					System.out.println("Please enter a valid response.");
					break;
				}
			}
		}
	}

	public boolean checkCredentials(String username, String password) {
		Employee e = employeeService.getEmployeeFromUsername(username);
		if(e == null) {
			System.out.println("There is no account associated with this username.");
			return false;
		}
		else if(e.getPassword().equals(password)) {
			System.out.println("Credentials accepted. Logging in.");
			return true;
		} else {
			System.out.println("Your username and password conbination is not correct. ");
			return false;
		}
	}

	public void allowAccess(Employee e) {
		new EmployeePortal();
	}
}
