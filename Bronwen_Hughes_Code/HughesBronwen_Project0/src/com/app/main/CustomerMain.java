package com.app.main;

import com.app.account.Employee;
import com.app.account.Login;
import com.app.account.Registration;
import com.app.account.RegistrationList;
import com.app.company.CompanyView;
	
	public class CustomerMain {
		public CustomerMain() {
			// TODO Auto-generated constructor stub
			//Scanner keyboard = new Scanner(System.in);
			
			
			
	
			while (true) {
				System.out.println("Would you like to login or register an account? (Login / Register)");
				String temp = ScannerSingleton.instance().nextLine().toUpperCase();
				if (temp.equals("LOGIN")) {
					System.out.println("Enter credentials.");
					new Login();
					break;
				} else if (temp.equals("REGISTER")) {
					System.out.println("Please fill out the forms.");
					Registration registrationTemp = new Registration();
					RegistrationList.getInstance().addRegistration(registrationTemp);
					//new CompanyView(new Employee("Kat", "kat", "Kat", "Hughes", true));
					
				
					
					break;
				} else if (temp.equals("EXIT")) {
					Main.exitApplication();
					break;
				} else {
					System.out.println("Invalid");
				}
			}
	
		}

	private boolean login(String username, String password, int pin) {
		return false;
	}

}
