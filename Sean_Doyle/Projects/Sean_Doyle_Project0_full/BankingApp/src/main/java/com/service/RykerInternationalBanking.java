package com.service;

import java.util.ArrayList;
import java.util.Scanner;


import org.apache.log4j.Logger;

import com.profiles.Account;
import com.profiles.Client;

public class RykerInternationalBanking {

	final private static Scanner s = new Scanner(System.in);
	final static Logger logger = Logger.getLogger(RykerInternationalBanking.class);
	
	public static void main(String[] args) {
			logger.info("Banking begun");
		
		// Ryker International Banking
		BankService bserv = new BankServiceImplementation();

		ArrayList<Account> accountList = new ArrayList<>();
		ArrayList<Client> clientList = new ArrayList<>();

		clientList = bserv.repopulateClients();
		System.out.println(clientList.toString());
		accountList = bserv.repopulateAccounts();
		System.out.println(accountList.toString());

		String howTo = loginScreen();
		
		ClientService cserv = new ClientServiceImplementation();
		//AccountService aserv = new AccountServiceImplementation();
		//EmployeeService eserv = new EmployeeServiceImplementation();
		

		RykerSystem loginManager = new RykerSystem();
		// using this switch statement prevent recursion effects (like stack overflow)
		while (!howTo.equals("quit")) {
			switch (howTo) {
			case "newLogin":
				howTo = loginScreen();
				break;
			case "newClient":
				howTo = newClientCheck();
				logger.info("newClientCheck " + howTo);
				break;
			case "clientCreate":
				howTo = cserv.clientCreator();
				logger.info("clientCreator " + howTo);
				if (!(howTo.equals("jointClientCreate"))) {
					howTo = loginManager.continueBanking(howTo);
					logger.info("newClientCheck " + howTo);
				}
				break;
			case "clientOrEmployee":
				howTo = clientOrEmployee();
				logger.info("clientOrEmployee " + howTo);
				break;
			case "clientLogin":
				howTo = cserv.clientLogin();
				howTo = loginManager.continueBanking(howTo);
				logger.info("clientLogin " + howTo);
				break;
			case "employeeLogin":
				howTo = loginManager.employeeLogin();
				logger.info("employeeLogin " + howTo);
				if (howTo.equals("adminLogin") || howTo.equals("employeeLogin")) {
					break;
				} else {
					howTo = loginManager.continueBanking(howTo);
					logger.info("continueBanking " + howTo);
				}
				break;
			case "adminLogin":
				howTo = loginManager.adminLogin();
				logger.info("adminLogin " + howTo);
				if (!howTo.equals("adminLogin")) {
					howTo = loginManager.continueBanking(howTo);
					logger.info("continueBanking " + howTo);
				}
				break;
			case "loginScreen":
				howTo = loginScreen();
				logger.info("loginScreen " + howTo);
				break;
			default:
				howTo = "quit";
			}
		}
		finalScreen(clientList, accountList);
	}

	public static String loginScreen() {
		System.out.println("\n\n\n\nWelcome to Ryker International Banking!");
		return "newClient";
	}

	public static void finalScreen(ArrayList<Client> clientList, ArrayList<Account> accountList) {
		System.out.println("\n\n\n\nThank You for choosing Ryker International Banking!\n\n\n\n");
		logger.info("Bank Closed");
		s.close();
		System.exit(0);
	}

	public static String newClientCheck() {
		System.out.println("Are you a NEW client? (Y/N)");
		if (s.next().toLowerCase().substring(0, 1).equals("y")) {
			return "clientCreate";
		} else {
			return "clientOrEmployee";
		}
	}

	public static String clientOrEmployee() {
		System.out.println("Are you a returning client? (Y/N)");
		String response = s.next().toLowerCase().substring(0, 1);
		if (response.equals("y")) {
			return "clientLogin";
		} else {
			return "employeeLogin";
		}
	}
}
