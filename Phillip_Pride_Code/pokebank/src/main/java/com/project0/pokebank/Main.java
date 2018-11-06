package com.project0.pokebank;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String response;
		Trainer currentTrainer = null;
		Employee currentWorker = null;
		Employee workr1 = new Employee("JakeM", "worker1"); // Default employee and admin
		Employee admin1 = new Employee("MaryK", "theBoss87");
		String usrname;
		String pword;
		String poke;
		Account box;
		boolean done = false;

		ArrayList<Trainer> trainers = new ArrayList<>();
		ArrayList<Employee> employees = new ArrayList<>();

		//trainers = getAllTrainers();
		employees.add(workr1);
		employees.add(admin1);

		// Checks to see if this is a User or a bank employee
		System.out.println(
				"Welcome to Phil's PC at the Tampa Pok\u00E9mon Center! Are you an employee(e) or a trainer? (t)");
		response = input.next().toLowerCase();

		if (response.toLowerCase().equals("t")) {

			System.out.println(
					"Nurse Joy: Welcome to Phil's PC at the Tampa Pok\u00E9mon Center! What would you like to during this visit? \n"
							+ "Make a new account (type new) or log in an existing account(type login)? (Type done to leave)");

			response = input.next().toLowerCase();
			// Do-while loop that checks logic for various functions depending on user input
			// using switch cases for a trainer;
			do {
				switch (response) {
				case "done": // Logs out current user, ends program

					System.out.println("Thank you visiting Phil's PC. We hope to you again!");
					done = true;
					continue;

				case "login": // Logs in an existing user
					System.out.print("Please enter your username: ");
					usrname = input.next().toLowerCase();
					System.out.print("Please enter your password (case-sensitive): ");
					pword = input.next();
					int cnt = 0;
					for (int i = 0; i < trainers.size(); i++) {
						if (usrname.equals(trainers.get(i).getUsername())
								&& pword.equals(trainers.get(i).getPassword())) {
							System.out.println("Welcome " + usrname + "! You are now logged in.");
							currentTrainer = trainers.get(i);
							cnt = 0;
							break;
						} else {
							cnt++;
						}
					}
					if (cnt != 0) {
						System.out.println("I'm afraid I could not find your credentials inside our database. "
								+ "Please try again or create a new account.");
					}
					break;

				case "new": // Creates a new user
					System.out.print("Please enter a username: ");
					usrname = input.next().toLowerCase();
					System.out.print("Please enter a password (case-sensitive): ");
					pword = input.next();
					//addTrainer(usrname, pword);
					// currentTrainer.applyForBox();
					System.out.println(
							"Thank you for creating an account with us. Please log in" + " with your new account");
					done = true;
					continue;

				case "apply": // Apply to open a PC box
					if (currentTrainer != null) {
						//currentTrainer.applyForBox();

						System.out.println("Thank you, your PC representative will review your "
								+ "application as soon as possible.");
					}
					break;

				case "d": // Deposit a Pokemon
					System.out.println("Please enter the name of Pok\u00E9mon you are depositing.");
					poke = input.next();
					currentTrainer.deposit(poke, currentTrainer.getUsername());
					System.out.println("Thank you! We will keep your " + poke + " safe until your return!");
					break;

				case "w": // Withdraw a Pokemon
					System.out.println("Which Pok\u00E9mon are you withdrawing?");
					poke = input.next();
					currentTrainer.withdraw(poke);
					System.out.println("Here is your " + poke + " safe and sound!");
					break;

				case "t": // Transfer a Pokemon from one account to another
					System.out.println("Which Pok\u00E9mon are you transferring?");
					poke = input.next();
					System.out.println("Who's box are you transferring to?");
					String newTrainer = input.next().toLowerCase();
					//currentTrainer.transfer(poke, newTrainer);
					break;

				default:
					System.out.println("I'm sorry I don't understand. Please try again.");
					response = input.next().toLowerCase();

				}
				System.out.println("What would you like to do next? Apply for a new PC box(apply).\n"
						+ " deposit(type d)\n" + "withdraw (w).\n" + "transfer (t).\n" + "logout (done)");
				response = input.next().toLowerCase();

			} while (!done);
		}

		else if (response.toLowerCase().equals("e")) {
			System.out.print("Please enter your username: ");
			usrname = input.next().toLowerCase();
			System.out.print("Please enter your password (case-sensitive): ");
			pword = input.next();
			int cnt = 0;
			for (int i = 0; i < employees.size(); i++) {
				if (usrname.equals(employees.get(i).getUsrname().toLowerCase())
						&& pword.equals(employees.get(i).getPassword())) {
					System.out.println("Welcome " + usrname + "! You are now logged in.");
					currentWorker = employees.get(i);
					break;
				} else {
					cnt++;
				}
			}
			if (cnt != 0) {
				System.out.println("The credentials you entered do not match any found inside our database. "
						+ "Please try again");
			}

			// While loop for employees.
			while (!done) {
				System.out.println("What would you like to do today? View clients (clients)\n "
						+ "View a specific client's boxed Pok\u00E9mon (boxed)\n"
						+ "Review open applications for new PC boxes (apps)\n "
						+ "Withdraw from a client's account (w)\n" + "Deposit into a client's account (d)\n"
						+ "Transfer a Pok\u00E9mon to a new account (t)\n" + "Delete client box (delete)\n"
						+ "Log out (done)");
				response = input.next().toLowerCase();
				switch (response) {
				case "clients":
					//getBoxApplications();
					break;

				case "boxed":
					System.out.println("Who's box would you like to look at? ");
					String client = input.next().toLowerCase();
					//System.out.println(getClientPokes(client));
					break;

				case "w":
					if (currentWorker.isAdmin()) {
						System.out.println("Which client's account are you withdrawing from?");
						String withdraw = input.next().toLowerCase();
						System.out.println("Which Pok\u00E9mon are you withdrawing?");
						poke = input.next().toLowerCase();
						for (Trainer t : trainers) {
							if (t.getUsername().equals(withdraw)) {
								t.withdraw(poke);
								break;
							}
						}
					} else {
						System.out.println("You must be an admin to perform this function");
					}
					break;

				case "d":
					if (currentWorker.isAdmin()) {
						System.out.println("Which client's account are you depositing into?");
						String depos = input.next().toLowerCase();
						System.out.println("Which Pok\u00E9mon are you depositing?");
						poke = input.next().toLowerCase();
						for (Trainer t : trainers) {
							if (t.getUsername().equals(depos)) {
								t.deposit(poke, depos);
								break;
							}
						}
					} else {
						System.out.println("You must be an admin to perform this function");
					}
					break;

				case "t":
					if (currentWorker.isAdmin()) {
						System.out.println("Which client's account are you withdrawing from?");
						String withdraw = input.next().toLowerCase();
						System.out.println("Which client's account are you depositing into?");
						String depos = input.next().toLowerCase();
						System.out.println("Which Pok\u00E9mon are you transfering?");
						poke = input.next().toLowerCase();
						for (Trainer t : trainers) {
							if (t.getUsername().equals(withdraw)) {
								for (Trainer t2 : trainers) {
									if (t.getUsername().equals(depos)) {
										//t.transfer(poke, depos);
									}
								}
								break;
							}
						}
					} else {
						System.out.println("You must be an admin to perform this function");
					}
					break;

				case "apps":
					System.out.println("Enter the username of the trainer whose application you are reviewing:");
					String applicant = input.next().toLowerCase();
					System.out.println("Are you approving(1) or denying(0) the application?");
					int ans = input.nextInt();
					//reviewBoxApplication(applicant, ans);
					break;

				case "delete":
					if (currentWorker.isAdmin()) {
						System.out.println("Which client's account are you deleting?");
						String withdraw = input.next().toLowerCase();
						for (Trainer t : trainers) {
							if (t.getUsername().equals(withdraw)) {
								break;
							}
						}
					} else {
						System.out.println("You must be an admin to perform this function");
					}
					break;

				case "done":
					System.out.println("You have been logged out.");
					done = true;

				}
			}
		}

		input.close();

	}

	/*public static void getBoxApplications() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT username FROM trainers WHERE hasAppliedForBox = 1";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			System.out.println("Here are your clients with pending box applications:");
			while (rs.next()) {
				System.out.println(rs.getString("username"));
				;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

	/*public static void reviewBoxApplication(String name, int ans) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE trainers SET hasAppliedForBox = 0 WHERE username = '" + name + "'";
			String sql2 = "UPDATE trainers SET hasBoxAccess = " + ans + " WHERE username = '" + name + "'";

			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps.executeUpdate();
			ps2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
}
