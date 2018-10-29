package q17;

import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {
		Scanner consolScanner = new Scanner(System.in);
		System.out.println("Enter principle: ");
		float principle = consolScanner.nextFloat();
		System.out.println("Enter montly rate as percentage in 0.xx format: ");
		float rate = consolScanner.nextFloat();
		System.out.println("Enter the number of months: ");
		int numMonths = consolScanner.nextInt();
		
		System.out.println("your interest is: " + (principle * rate * numMonths));
		
		

	}

}
