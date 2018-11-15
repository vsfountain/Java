package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.main.RunApp;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminOptions.
 */
public class AdminOptions {

	
	/**
	 * Show admin options.
	 *
	 * @return the int
	 */
	public static int showAdminOptions() {
		int choice = -1;
		Scanner scan = RunApp.scan;
		boolean valid = false;
		System.out.println("Please enter a number for the following options:\n");
		while (!valid) {
		System.out.println( "[1] View all client info"
				+ "\n[2] Validate accounts"
				+ "\n[3] Close accounts"
				+ "\n[4] withdraw from users account"
				+ "\n[5] deposit to users account"
				+ "\n[6] transfer between a users accounts"
				+ "\n[7] Log Out");
			try {
				//System.out.println("thing");
				choice = scan.nextInt();
				if (choice >=1 || choice <= 4) {
					valid = true;
				}
			} catch (InputMismatchException a){
				
				scan.next(); // when error this will prevent infinite loop
				//a.printStackTrace();
			}
			
			if(!valid) {
				System.out.println("Choice not valid, try again.");
			}
		}
		//scan.next();
		//scan.close();
		return choice;
		
	}
}
