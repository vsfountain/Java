package com.bankofdikoko.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*To run my project, please register first and then log in to attempt the functionality that users have to view, edit accounts
 * As of right now my project only remembers the information of the obj that is created when registering a user and forgets
 * that object once another user is registered or once the program is closed.
 * */

public class Main {
	public static Scanner in = new Scanner(System.in);
	public static User obj;
	public static User temp;
	public static String path;
	public static ArrayList<User> users = new ArrayList<>();
	public static UserSerializable u = new UserSerializable();

	public static void main(String[] args) {
		try{
			displayMenu();
			}catch(NullPointerException e) {
				displayMenu();
			}catch(ArrayIndexOutOfBoundsException s) {
				//displayMenu();
			}
	}

	public static void getObject(String path) {

		String name = UserSerializable.readObject(path.toString()).getFirstName();
		System.out.println(name);
	}

	// Menu logic
	static void displayMenu() {
		System.out.println("Welcome to the Bank of Dikoko App!");
		System.out.println("Please select one of the following Options: ");
		obj = new User();

		// Initialize new User Obj

		String response = "";
		
		// Establish terminating condition
		while (!response.equals("3")) {
			System.out.println("[1] Register\n[2]Log in\n[3] Exit");
			response = in.next();

			if (response.equals("1")) {
				//obj = new User();
				

				System.out.println("Create username");
				String username = in.next();
				obj.setUserName(username);

				System.out.println("You entered: " + obj.getUserName());

				System.out.println("Create password: ");
				String password = in.next();
				obj.setPassword(password);

				System.out.println("Enter first name: ");
				String firstN = in.next();
				obj.setFirstName(firstN);

				System.out.println("Enter last name: ");
				String lastN = in.next();
				obj.setLastName(lastN);

				System.out.println("Welcome " + firstN + lastN
						+ "\nYour account has been created!\n\t Password has been set: " + obj.getPassword());
				System.out.println("Returning to main menu");
				
				UserSerializable usm = new UserSerializable();
				usm.writeObject(firstN, obj);

				users.add(obj);
				System.out.println(users);
				System.out.println(users.get(users.indexOf(obj)));
				System.out.println(users.size());
				temp = users.get(users.indexOf(obj));
				temp.getUserName();
				continue;
			}

			if (response.equals("2")) {
				System.out.println("Enter username: ");
				String username = in.next();
				System.out.println("Enter password: ");
				String password = in.next();
				if (obj==null) {
					System.out.println("We are unable to find the account associated with that username.");
					break;
				}
				
				//if (username.equals(obj.getUserName()))
				
				if(users.get(users.indexOf(temp)).getUserName().equals(username)){
					System.out.println("Authenticating...");

					if (users.get(users.indexOf(temp)).getPassword().equals(password)) {
						System.out.println("Login Successful");

						String choice = "";
						Account a = new Account();
						while (!choice.equals("5")) {
							System.out.println("[1] View Balance\n[2] Deposit Money \n[3] Withdraw Money \n[4] Close account\n[5] Exit");
							choice = in.next();
							if (choice.equals("1")) {
								a.setCustomerName(obj.getFirstName());
								System.out.println(a.toString());
							} else if (choice.equals("2")) {
								System.out.println("Enter Deposit Amount");
								int deposit = in.nextInt();
								a.deposit(deposit);
								a.toString();
								continue;
							} else if (choice.equals("3")) {
								System.out.println("How much would you like to withdraw?");
								int withdraw = in.nextInt();
								a.withdraw(withdraw);
								a.toString();
								continue;
							}else if(choice.equals("4")) {
								System.out.println("Closing account....." );
								users.remove(obj);
								choice = "5";
								break;								
							}else choice = "5";

						}
					} else System.out.println("Login Unsucessful");

				}
			}
		}System.out.println("Now exiting application.");
			System.exit(0);

	}
}
