package com.javahomework.questions17;

import java.util.Scanner;

public class InterestCalculator{
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter principal: ");
		String principal = in.next();
		
		
		System.out.println("Enter Rate: ");
		String rate = in.next();
		System.out.println("Enter number of years: ");
		String time = in.next();
		System.out.print("Interest is equal to: ");
		System.out.println(Double.parseDouble(principal)*Double.parseDouble(rate)*Double.parseDouble(time));
	}

}
