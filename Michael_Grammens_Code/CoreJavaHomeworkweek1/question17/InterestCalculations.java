package com.homework.question17;

import java.util.Scanner;

public class InterestCalculations {
	public static void main(String[] args) {
		System.out.println("Enter principal, rate and time.");
		Scanner consoleInput = new Scanner(System.in);
		try {
			double principal = consoleInput.nextDouble();
			double rate = consoleInput.nextDouble();
			double time = consoleInput.nextDouble();
			System.out.println("The interest using this principal, rate and time is: " + (principal*rate*time));
		}
		catch(Exception e){
			System.out.println("Thats the wrong input, try an integer please.");
		}
		consoleInput.close();
	}
}
