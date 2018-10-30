package q17;

import java.util.Scanner;
/*
 * accept runtime command line inputs for calculating the interest from a 
 * principle amount based on a continuous interest rate
 * interest = (principle amount)*(interest rate)*(interest modifier (time based) = 1)*(time) = P*R*T
 */
public class Interest {
	public static void main(String[] args) {
		double rate;
		double years;
		double principle;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the decimal value for the Prinicple: ");
		principle = s.nextDouble();
		System.out.println("Please enter the decimal value for the Rate of Interest: ");
		rate = s.nextDouble();
		System.out.println("Please enter the integer value for the Number of Years: ");
		years = s.nextDouble();
		System.out.println("The interest amount is: " + principle*rate*years);
		s.close();
	}
}
