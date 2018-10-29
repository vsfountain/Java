package com.example.bank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/*apple|elppa*/
		
		
		System.out.println();
		
		
		runProgram();
	}
	
	
	public static void runProgram() {
		
		
		ArrayList<Customer> Aaa = CustomerLoader.loadCustomer();
		ArrayList<Account> Aaaa = AccountLoader.loadAccount();
		ArrayList<Employee> Aaaaa = EmployeeLoader.loadEmployee();
		System.out.println(Aaa);
		
		
		while(true) {
		
		System.out.println("Would you like to "
							+ "\na) Register"
							+ "\nb) Log In (customer)"
							+ "\nc) Log In (employee)");
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		
		if(a.equals("a")) {
			registerPrompt(sc, Aaa);
		} else if (a.equals("b")) {
			
			
			login(sc, Aaa, Aaaa);
			
			
			
			
		} else if (a.equals("c")) {
			eLogin(sc, Aaaa, Aaaaa);
		} else {
			System.out.println("Please choose 'a', 'b', or 'c'");
		}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}


	private static void eLogin(Scanner sc, ArrayList<Account>Aaaa, ArrayList<Employee> Aaaaa) {
		// TODO Auto-generated method stub
		
		boolean loggedInNo= true;
		Employee aaaaa = null;
		while(loggedInNo) {
			boolean userName = true;
			String a = "";
			while(userName) {
			System.out.println("Enter username");
			a = sc.next();
			if(a.equals("")) {
				System.out.println("Please enter a username");
			} else {
				userName = false;
			}
			}
			boolean pass = true;
			String aa = "";
			while(pass) {
				System.out.println("Enter password");
				aa = sc.next();
				if(aa.equals("")) {
					System.out.println("Please enter password");
				} else {
					pass = false;
				}
			}
			
			boolean foundU = false;
			for(int i = 0; i < Aaaaa.size(); i++) {
				if(Aaaaa.get(i).getUsername().equals(a)) {
					foundU = true;
					if(Aaaaa.get(i).getPassword().equals(aa)) {
						aaaaa = Aaaaa.get(i);
						loggedInNo = false;
					} else {
						System.out.println("That username/password combo "
											+ "did not match our records"
											+ "\nPlease try again");
					}
				}
			}
			
			if(!foundU) {
				System.out.println("That username/password combo "
									+ "did not match our records"
									+ "\nPlease try again");
			}
			
		}
			System.out.println("Employee: " + aaaaa.getUsername()
								+ "\nLogged In!");

			boolean loggedIn = true;
			while(loggedIn) {

				System.out.println(/*"User: " + aaaaa.getUserName()
				+ "\nLogged In!"
				+ */"\nWhat would you like to do"
				+ "\na) Register an Account"
				+ "\nb) Register a Joint Account"
				+ "\nc) View Accounts");




String aaaaaaa = sc.next();
			
			
			
		}
		
	}


	private static void login(Scanner sc, ArrayList<Customer> aaa, ArrayList<Account>Aaaa) {
		// TODO Auto-generated method stub
		
		
		boolean loggedInNo= true;
		Customer aaaaa = null;
		while(loggedInNo) {
		boolean userName = true;
		String a = "";
		while(userName) {
		System.out.println("Enter username");
		a = sc.next();
		if(a.equals("")) {
			System.out.println("Please enter a username");
		} else {
			userName = false;
		}
		}
		
		boolean pass = true;
		String aa = "";
		while(pass) {
			System.out.println("Enter password");
			aa = sc.next();
			if(aa.equals("")) {
				System.out.println("Please enter password");
			} else {
				pass = false;
			}
		}
		boolean foundU = false;
		for(int i = 0; i < aaa.size(); i++) {
			if(aaa.get(i).getUserName().equals(a)) {
				foundU = true;
				if(aaa.get(i).getPassword().equals(aa)) {
					aaaaa = aaa.get(i);
					loggedInNo = false;
				} else {
					System.out.println("That username/password combo "
										+ "did not match our records"
										+ "\nPlease try again");
				}
			}
		}
		
		if(!foundU) {
			System.out.println("That username/password combo "
								+ "did not match our records"
								+ "\nPlease try again");
		}
		
		}
		
		System.out.println("User: " + aaaaa.getUserName()
							+ "\nLogged In!");
		
		boolean loggedIn = true;
		while(loggedIn) {
		
		System.out.println(/*"User: " + aaaaa.getUserName()
							+ "\nLogged In!"
							+ */"\nWhat would you like to do"
							+ "\na) Register an Account"
							+ "\nb) Register a Joint Account"
							+ "\nc) View Accounts");
		
		
		
		
		String aaaaaaa = sc.next();
		if(aaaaaaa.equals("a")) {
			applyForAccount(Aaaa, aaaaa);
		} else if (aaaaaaa.equals("b")) {
			
		} else if (aaaaaaa.equals("c")) {
			viewAccountsCustomer(Aaaa, aaaaa);
		} else {
			
		}
		}
		
	}


	private static void viewAccountsCustomer(ArrayList<Account> Aaaa, Customer aaaaa) {
		// TODO Auto-generated method stub
		System.out.println("Which Account Would You Like To Select?"
							+"\nAccount List:");
		DecimalFormat formatter = new DecimalFormat("#0.00");
		ArrayList<Account> Aaaaa= new ArrayList<>();
		for(int i = 0; i<Aaaa.size(); i ++) {
			if(Aaaa.get(i).isApproved() && !Aaaa.get(i).isCancelled() && (Aaaa.get(i).getCustomerNum()==aaaaa.getCustomerNum() || Aaaa.get(i).getJointCustomerNo()==aaaaa.getCustomerNum())) {
				
				System.out.println(Aaaa.get(i).getAccountNo() + ") Balance: "
									+ "$" + formatter.format(Aaaa.get(i).getAmount()));
				Aaaaa.add(Aaaa.get(i));
			}
		}
		if(Aaaaa.size() == 0) {
			System.out.println("You have no accounts");
			return;
		} else {
			
		}
		
		
		
		
		
	}


	private static void applyForAccount(ArrayList<Account> Aaaa, Customer aaaaa) {
		// TODO Auto-generated method stub
		/*System.out.println("You have applied for an account");*/
		Account a = new Account(aaaaa.getCustomerNum(), Aaaa.size() + 1, false, 0, true);
		Aaaa.add(a);
		AccountLoader.writeAccount(Aaaa);
		System.out.println("You have applied for an account");
		
	}


	private static void registerPrompt(Scanner sc, ArrayList<Customer> aaa) {
		// TODO Auto-generated method stub
		boolean userName = true;
		String a;
		while(userName) {
		System.out.println("What would you like your username to be?");
		a = sc.next();
		for(int i = 0; i<aaa.size(); i++) {
			if(a.equals(aaa.get(i).getUserName())) {
				System.out.println("That username is already in use, please enter a different username");
				break;
			}
			if(i == aaa.size() - 1 && !a.equals(aaa.get(i))) {
				userName = false;
			}
		}
		boolean pass = true;
		String aa = "";
		while(pass) {
		System.out.println("What would you like your password to be?");
		aa = sc.next();
		if(aa.equals("")) {
			System.out.println("Please enter a password");
		}else {
			pass = false;
		}
		}
		
		boolean firstname = true;
		String aaaaa = "";
		while(firstname) {
		System.out.println("What is your first name?");
		aaaaa = sc.next();
		if(aaaaa.equals("")) {
			System.out.println("Please enter a first name");
		} else {
			firstname = false;
		}
		}
		
		boolean lastname = true;
		String aaaaaaaa = "";
		while(lastname) {
		
		System.out.println("What is your last name?");
		aaaaaaaa = sc.next();
		if(aaaaaaaa.equals("")) {
			System.out.println("Please enter a last name");
		} else {
			lastname = false;
		}
		}
		
		
		Customer aaaaaaa = new Customer(aaa.size() + 1, a, aa, aaaaa, aaaaaaaa);
		aaa.add(aaaaaaa);
		
		CustomerLoader.writeCustomer(aaa);
		
		System.out.println("Thank you for registering " + aaaaaaa.getFirstName() + aaaaaaa.getLastName()
							+ "\nUsername: " + aaaaaaa.getUserName());
		
		}
	}


	/*private static void registerPrompt(Scanner sc, Arr) {
		// TODO Auto-generated method stub
		System.out.println("What would you like your username to be?");
		
		
	}*/
	
	
	
	

}
