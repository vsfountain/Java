package controller.dataio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInt {
	private static Scanner scanInt = new Scanner(System.in);
	public static int scanInt() {

		int toReturn = -1;
		
		while (toReturn == -1) {
			try {
				toReturn = scanInt.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Only integers expected, try again.");
				toReturn=-1;
				scanInt.next();
			}
			if (toReturn < 0) {
				System.out.println("Integer must be positive.");
				toReturn = -1;
			}
			
		}

		return toReturn;
	}
	
	public void close() {
		scanInt.close();
	}

}
