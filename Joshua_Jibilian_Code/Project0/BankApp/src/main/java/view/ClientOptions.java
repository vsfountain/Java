package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.dataio.ScannerInt;
import controller.main.RunApp;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientOptions.
 */
public class ClientOptions {
	
	/**
	 * Show client options.
	 *
	 * @return the int
	 */
	public static int showClientOptions() {
		int choice = -1;
		Scanner scan = RunApp.scan;
		boolean valid = false;
		System.out.println("Please enter a number for the following options:\n");
		while (!valid) {
		System.out.println( "[1] View info\n[2] Apply for account\n[3] Make a Withdraw\n[4] Make a deposit"
				+ "\n[5] Transfer funds.\n[6] Apply for joint account\n[7] Log out");
			try {
				//System.out.println("thing");
				choice = ScannerInt.scanInt();
				if (choice >=1 || choice <= 6) {
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
