package q17;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter account principal: ");
		double principal = input.nextDouble();
		System.out.print("Enter account interest rate: ");
		double rate = input.nextDouble();
		System.out.print("Enter account duration (years): ");
		double duration = input.nextDouble();
		
		double interest = principal*(rate/100)*duration;
		double value = interest+principal;
		System.out.println("At the end of the account duration, you will have earned: $" + interest + " in interest");
		System.out.println("The account value will be: $" + value);
		input.close();
	}

}
