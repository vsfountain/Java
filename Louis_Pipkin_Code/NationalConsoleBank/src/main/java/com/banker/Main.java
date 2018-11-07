package com.banker;

import java.util.Map;
import java.util.Scanner;
//import java.util.logging.Logger;


import com.banker.model.users.Admin;
import com.banker.model.users.Associate;
import com.banker.model.users.Client;
import com.banker.model.users.User;
import com.banker.service.BankerService;
import com.banker.service.BankerServiceImpl;

public class Main {

	public static void main(String[] args) {

		int option = -1;
		boolean flag;
		String userID = "";
		String password = "";

		BankerService service = new BankerServiceImpl();
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		Map<String, User> allUsers = service.getAllUsers();
		
		MenuPrinter.welcome();
		// Main loop
		while (option != 90) { // 90 will be our final exit option
			if (option == -1) {
				MenuPrinter.initial();
				option = Views.getOption(scanner);
				if (option != 1 && option != 2 && option != 90) { // catch invalid options
					option = -1;
				}
			}
			if (option == 1) { // login
				flag = false;
				while (flag == false) {
					System.out.println("Please enter your user name.");
					userID = Views.getInput(scanner);
					System.out.println("Please enter your password.");
					password = Views.getInput(scanner);
					//password.trim();
					//userID.trim();
					//System.out.println("inline users= "+allUsers);
					if (service.isUser(userID)) {
						// System.out.println("found user: "+allUsers.get(userID).getUserName());
						user = service.getUser(userID);
						// password check
						//System.out.println("id:'"+userID+"'pass:'"+password+"'");
						if (password.equals(user.getPassword())) {
							flag = true;
							option = -2;
						} else {
							// go back to initial
							System.out.println("Password invalid.\n");
							user = null;
							flag = true;
							option = -1;
						}
					} else {
						System.out.println("User name not found");
					}
				}
			} else if (option == 2) { // register
				flag = false;
				while (flag == false) {
					System.out.println("Please enter a user name.");
					userID = Views.getInput(scanner);
					System.out.println("Please enter a password.");
					password = Views.getInput(scanner);

					if (service.isUser(userID)) {
						System.out.println("User already exists");
					} else {
						service.addUser(userID, password, "client");
						user = service.getUser(userID);
						flag = true;
						// go to home screen
					}
				}
			}

			if (user instanceof Client) {
				option = Views.clientLoop(user);
			} else if (user instanceof Associate) {
				option = Views.associateLoop(user);
			} else if (user instanceof Admin) {
				option = Views.adminLoop(user);
			}
			//service.commit();
		}

		System.out.println("Good Bye");
	}

}
