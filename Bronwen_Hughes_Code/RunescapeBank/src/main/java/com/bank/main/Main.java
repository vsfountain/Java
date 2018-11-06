package com.bank.main;

import com.bank.main.customer.CustomerMainMenu;
import com.bank.main.employee.EmployeeMainMenu;

public class Main {
	public static void main(String[] args) {
		
		//AccountService accountService = new AccountServiceImpl();
		
		//accountService.createAccountDB();
		
		/*Customer c = new Customer("username", "password", "first", "last", true);
		ArrayList<Customer> cList = new ArrayList<>();
		cList.add(c);
		Account a = new Account(1000.32, cList);
		accountService.addAccount(a);
		System.out.println("Done!");*/
		//List<Account> accounts 	= accountService.getAllAccounts();
		
		//for(Account ac: accounts) {
		//	System.out.println(a);
		//}
		
		//EmployeeService employeeService = new EmployeeServiceImpl();
		//employeeService.createEmployeeDB();

		//Employee employee = new Employee(1,"Admin", "Admin", "First", "Last", false);
		//employeeService.addEmployee(employee);
		
		//Employee employee = new Employee(2,"Admin2", "Admin2", "First2", "Last2", true);
		//employeeService.addEmployee(employee);
		
		//String username = "Admin2";
		//Employee e = employeeService.getEmployeeFromUsername(username);
		//System.out.println(e.getPassword());
		
		//new CustomerMainMenu();
		
		System.out.println("[A] Customer [B] Employee");
		String temp = ScannerSingleton.instance().next().toUpperCase();
		switch(temp) {
		case "A":
			new CustomerMainMenu();
			break;
		case "B":
			new EmployeeMainMenu();
			break;
		default:
			break;
		}
		//new EmployeeMainMenu();
	}
	
}
