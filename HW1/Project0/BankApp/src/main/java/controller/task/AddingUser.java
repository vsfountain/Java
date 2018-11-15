package controller.task;

import java.util.Scanner;

import controller.main.RunApp;
import controller.services.UserService;
import controller.services.UserServicesImpl;
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
		
		String firstName = "";
		String lastName = "";
		String email = "";
		String password = "";
		//User toAdd = null;
		Scanner scan = RunApp.scan;
		do {
			System.out.println("Please enter your first name:");
			firstName = scan.next();
			System.out.println("Please enter your last name:");
			lastName = scan.next();
			System.out.println("\nPlease enter you email: ");
			email = scan.next();
			System.out.print("\nPlease enter password: ");
			password = scan.next();
			//toAdd = new ClientUser(firstName, lastName, email, password);
			System.out.println("\nYour entry:\nName: " + firstName
					+ " " + lastName + "\nEmail: " + email);
		} while (ConfirmationView.confirmation() != 1);
		UserService service = new UserServicesImpl();
		Boolean results = service.registerUser(firstName, lastName, password, email);
		//System.out.println(results); 
		if (!results) {
			System.out.println("\nThat email is already in use.");
		} else {
			System.out.println("\nYou have registered. Log in to create an account");

		}
		
	}
}
