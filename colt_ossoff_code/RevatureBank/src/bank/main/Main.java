package bank.main;

import java.util.ArrayList;
import java.util.Scanner;

import bank.accounts.Account;
import bank.accounts.Transaction;
import bank.people.Customer;
import bank.people.Employee;

public class Main {
	static ArrayList<Customer> customers;
	static ArrayList<Employee> employees;
	static ArrayList<Account> accounts;
	static ArrayList<Transaction> transactions;
	
	static Customer sesCust;
	static Employee sesEmpl;

	static void creatUserAccount(Scanner s) {
		System.out.print("Full Name: ");
		String name = s.nextLine();
		System.out.print("Pick a username: ");
		String uName = s.next();
		String pwd, cpwd;
		do {
			System.out.print("Password: ");
			pwd = s.next();
			System.out.print("Confirm password: ");
			cpwd = s.next();
			if (!pwd.equalsIgnoreCase(cpwd))
				System.out.println("Your passwords do not pass.  Try again.");
		} while (pwd.equals(cpwd));
		int id, accNum;
		if (customers.size() == 0) {
			id = 100;
			accNum = 1000;
		} else {
			id = customers.get(customers.size() - 1).getId() + 1;
			accNum = accounts.get(accounts.size() - 1).getId() + 1;
		}
		sesCust = new Customer(name, accNum, uName, pwd);
		ArrayList<Integer> o = new ArrayList<Integer>();
		o.add(id);
		Account a = new Account(0, accNum, o);
		customers.add(sesCust);
		sesCust.addAccount(accNum);
		accounts.add(a);
		System.out.println("Thank you for joining");
	}

	static void loginEmployee(Scanner s) {
		System.out.print("Username: ");
		String uName = s.next();
		System.out.print("Password: ");
		String pwd = s.next();
		for(Employee e: employees)
			if(e.login(uName, pwd))
				sesEmpl = e;
		System.out.println("Welcome back " + sesEmpl.getName());
	}
	static void loginCustomer(Scanner s) {
		
	}
	public static void main(String[] args) {
		//Load files
		IOHandlerStream.loadCustomers(customers);
		IOHandlerStream.loadEmployees(employees);
		IOHandlerStream.loadAccounts(accounts);
		IOHandlerStream.loadTransactions(transactions);
		
		Scanner user = new Scanner(System.in);
		
		//Begin UI
		System.out.println("Hello. Are you a (Customer) or an (Employee)");
		String responce = user.next();
		if(responce.equalsIgnoreCase("customer")) {
			System.out.println("Are you a (new) or (returning) customer");
			responce = user.next();
			if(responce.equalsIgnoreCase("new")) creatUserAccount(user);
				
		} else if(responce.equalsIgnoreCase("employee")) {
			loginEmployee(user);
		} else {
			System.out.println("You're new here ain'cha. Ok then, create an account.");
			creatUserAccount(user);
		}
	}

}
