package com.project0.pokebank;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String response;
		Trainer currentTrainer = null;
		Employee currentWorker = null;
		Trainer t1 = new Trainer("Clutch", "FireType23"); // Starting trainer
		Employee workr1 = new Employee("JakeM", "worker1"); // Default employee and admin
		Employee admin1 = new Employee("MaryK", "theBoss87");
		String usrname;
		String password;
		String poke;
		Account box;
		boolean done = false;

		String filename = "./trainerAccountInfo.txt";

		List<Trainer> trainers = new ArrayList<>();
		List<Employee> employees = new ArrayList<>();

		trainers.add(t1);
		t1.applyForBox("Box1");
		workr1.addClient(t1);
		writeObject(filename, t1);

		// readObject(filename);
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
				case "done":

					System.out.println("Thank you visiting Phil's PC. We hope to you again!");
					done = true;
					writeObject(filename, currentTrainer);
					// readObject(filename);
					continue;

				case "login":
					System.out.print("Please enter your username: ");
					usrname = input.next().toLowerCase();
					System.out.print("Please enter your password (case-sensitive): ");
					password = input.next();
					int cnt = 0;
					for (int i = 0; i < trainers.size(); i++) {
						if (usrname.equals(trainers.get(i).getUsername())
								&& password.equals(trainers.get(i).getPassword())) {
							System.out.println("Welcome " + usrname + "! You are now logged in.");
							currentTrainer = trainers.get(i);
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

				case "new":
					System.out.print("Please enter a username: ");
					usrname = input.next().toLowerCase();
					System.out.print("Please enter a password (case-sensitive): ");
					password = input.next();
					currentTrainer = new Trainer(usrname, password);
					trainers.add(currentTrainer);
					workr1.addClient(currentTrainer);
					System.out.println("Thank you for creating an account with us");
					break;

				case "apply":
					if (currentTrainer != null) {
						System.out.println("Enter a name for your box");
						currentTrainer.applyForBox(input.next());

						System.out.println("Thank you, your PC representative will review your "
								+ "application as soon as possible.");
					}
					break;

				case "d":
					System.out.println("Please enter the name of Pok\u00E9mon you are depositing.");
					poke = input.next();
					System.out.println("Which box would you like to place them in?");
					box = currentTrainer.getBox(input.next());
					currentTrainer.deposit(box, poke);

					System.out.println("Thank you! We will keep your " + poke + " safe until you return");
					break;
				case "w":
					System.out.println("Which Pok\u00E9mon are you withdrawing?");
					poke = input.next();
					System.out.println("Which box is it in?");
					box = currentTrainer.getBox(input.next());
					currentTrainer.withdraw(box, poke);

				case "t":
					System.out.println("Which Pok\u00E9mon are you transferring?");
					poke = input.next();
					System.out.println("Which box are you tranferring from?");
					box = currentTrainer.getBox(input.next());
					System.out.println("Which box are you transferring to?");
					Account box2 = currentTrainer.getBox(input.next());
					currentTrainer.transfer(poke, box, box2);
					break;

				default:
					System.out.println("I'm sorry I don't understand. Please try again.");
					response = input.next().toLowerCase();

				}
				System.out.println(
						"What would you like to do next? Apply for a new PC box(apply), deposit(type d), withdraw(w), transfer(t), logout(done)");
				response = input.next().toLowerCase();

			} while (!done);
		}

		else if (response.toLowerCase().equals("e")) {
			System.out.print("Please enter your username: ");
			usrname = input.next().toLowerCase();
			System.out.print("Please enter your password (case-sensitive): ");
			password = input.next();
			int cnt = 0;
			for (int i = 0; i < employees.size(); i++) {
				if (usrname.equals(employees.get(i).getUsrname()) && password.equals(employees.get(i).getPassword())) {
					System.out.println("Welcome " + usrname + "! You are now logged in.");
					currentWorker = employees.get(i);
				}
			}
			if (cnt != 0) {
				System.out.println("The credentials you entered do not match any found inside our database. "
						+ "Please try again");
			}

			// While loop for employees. Currently an infinite loop
			while (!done) {
				System.out.println("What would you like to do today? View clients(clients). "
						+ "View open applications for new PC boxes(apps).");
				response = input.next().toLowerCase();
				switch (response) {
				case "clients":
					currentWorker.getClients();
					

				}
			}
		}

	}

	static void readObject(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object obj = ois.readObject();// de-serialization
			System.out.println(obj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void writeObject(String filename, Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))) {
			oos.writeObject(obj); // serialization

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
