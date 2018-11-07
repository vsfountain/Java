package controller.task;

import java.util.Scanner;

import controller.main.RunApp;
import model.users.AllUsers;
import model.users.ClientUser;
import model.users.User;
import view.ConfirmationView;


// TODO: Auto-generated Javadoc
/**
 * Handles the task of adding user through one static method.
 */
public class AddingUser {
	
	/**
	 * Adds the user.
	 */
	public static void AddUser() {
		//PotentialUsers addTo = PotentialUsers.getInstance();
		AllUsers users = AllUsers.getInstance(); 
		String name = "";
		String email = "";
		String password = "";
		User toAdd = null;
		Scanner scan = RunApp.scan;
		do {
			System.out.println("Please enter your name:");
			name = scan.next();
			System.out.println("\nPlease enter you email: ");
			email = scan.next();
			System.out.print("\nPlease enter password: ");
			password = scan.next();
			toAdd = new ClientUser(name, email, password);
			System.out.println("\nYour entry:\nName: " + name + "\nEmail: " + email);
		} while (ConfirmationView.confirmation() != 1);
		if (users.getUsers().contains(toAdd)) {
			System.out.println("\nThat email is already in use.");
		} else {
			users.addUser(toAdd);
			System.out.println("\nYou have registered. Log in to create an account");

		}
		
	}
}
