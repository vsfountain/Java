package com.service;

import java.util.Scanner;

public class RykerSystem {

	private static final String EMPLOYEEACCESSCODE = "Snoflake";
	private static final String EMPLOYEEPASSPHRASE = "123Monkey";
	private static final String ADMINISTRATORACCESSCODE = "Fluffy";
	private static final String ADMINISTRATORPASSPHRASE = "CafeBabe";
	//private BankService bserv = new BankServiceImplementation();
	//private ClientService cserv = new ClientServiceImplementation();
	private EmployeeService eserv = new EmployeeServiceImplementation();
	//private AccountService aserv = new AccountServiceImplementation();

	static Scanner s = new Scanner(System.in);

	public String continueBanking(String oldHowTo) {
		s.reset();
		System.out.println("Do you wish to continue banking? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			System.out.println("\n\n\n\n");
			return oldHowTo;
		} else {
			s.close();
			return "quit";
		}
	}

	public String employeeLogin() {
		//s.reset();
		System.out.println("Are you a Bank Administrator? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			return "adminLogin";
		} else {
			System.out.println("Please enter Employee Pass Phrase: ");
			if (s.next().equals(EMPLOYEEPASSPHRASE)) {
				eserv.doWork(EMPLOYEEACCESSCODE);

				return "loginScreen";// need to override
			} else {
				System.out.println("Invalid Employee Pass Phrase. Would you like to re-enter password? (Y/N)");
				if (s.next().toLowerCase().substring(0, 1).equals("y")) {

					return "employeeLogin";
				} else {

					return "loginScreen";
				}
			}
		}
	}

	public String adminLogin() {
		//s.reset();
		System.out.println("Please enter Administrator Pass Phrase: ");
		if (s.next().equals(ADMINISTRATORPASSPHRASE)) {
			eserv.doWork(ADMINISTRATORACCESSCODE);
			return "loginScreen";// need to override
		} else {
			System.out.println("Invalid Administrator Pass Phrase. Would you like to re-enter password? (Y/N)");
			if (s.next().toLowerCase().substring(0, 1).equals("y")) {
				return "adminLogin";
			} else {
				return "loginScreen";
			}
		}
	}
}