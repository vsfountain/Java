package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.dataio.ScannerInt;
import controller.main.RunApp;


// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmationView. This just asks if what they enterd is correct. Info should be printed before call to static method
 */
public class ConfirmationView {
 
 /**
  * Asks what user enter was correct. Info should be printed before call to this method
  *
  * @return int -1 if bad input, 1 if yes, 2 if no
  */
 public static int confirmation() {
	 int choice = -1;
		Scanner scan = RunApp.scan;
		boolean valid = false;
		System.out.println("Is this correct?");
		while (!valid) {
		System.out.println( "[1] Yes\n[2] No");
			try {
				//System.out.println("thing");
				choice = ScannerInt.scanInt();
				if (choice >=1 || choice <= 2) {
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
		//scan.close();
		return choice;
		
 }
}
