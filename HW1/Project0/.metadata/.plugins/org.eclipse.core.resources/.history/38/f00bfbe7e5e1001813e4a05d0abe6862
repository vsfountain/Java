package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.main.RunApp;

// TODO: Auto-generated Javadoc
/**
 * The Class TopMenu.
 */
public class TopMenu {

	/**
	 * Top menu choice.
	 *
	 * @return the int
	 */
	public static int topMenuChoice() {
		int choice = -1;
		Scanner scan = RunApp.scan;
		boolean valid = false;
		System.out.println("Please enter a number for the following options:\n");
		while (!valid) {
		System.out.println( "[1] Login\n[2] Create account\n[3] Close");
			try {
				//System.out.println("thing");
				choice = scan.nextInt();
				if (choice >=1 || choice <= 3) {
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
