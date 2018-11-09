package com.example.main;

import java.util.Scanner;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

public class LogInEmployee {

	
	/*public static Employee logInEmployeePrompt() {
		
		String username = LogInEmployee.askEmployeeUsername();
		if(username.equals("b")) {
			return null;
		}
		String password = LogInEmployee.
		
		
		
	}
	
	public static String askEmployeePassword(String username) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter password"
							+ "\nb) Exit");
		
		boolean lo = true;
		
		
		
	}*/
	
	
	
	
	public static String askEmployeeUsername() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter username"
							+ "\nb) Exit");
		
		boolean lo = true;
		while(lo) {
			String username = sc.next();
			if(username.equals("b")) {
				return "b";
			} else if (username.equals("")) {
				System.out.println("Please enter username");
			} else {
				EmployeeService employeeService = new EmployeeServiceImpl();
				String dbUsername = employeeService.getEmployeeName(username);
				if(dbUsername.equals("")) {
					System.out.println("Invalid username " + "\"" + username + "\""
										+ "\nPlease try again");
				} else {
					return username;
				}
			}
			
		}
		return null;
		
	}
	
	
	
}
