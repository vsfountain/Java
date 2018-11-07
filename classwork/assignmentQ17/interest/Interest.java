package com.assignmentQ17.interest;

import java.util.Scanner;
public class Interest {
	
	public static void main(String[] args) {
		calcInterest();
	}
	
	public static void calcInterest() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Please input principal, followed by rate, followed by time in years");
		float principal = sc.nextFloat(); 
		float rate = sc.nextFloat();
		float time = sc.nextFloat();
		float interest = principal * rate * time;
		System.out.println("Principal: " + principal);
		System.out.println("Rate: " + rate);
		System.out.println("Time: " + time);
		System.out.println("The interest is " + interest);
		//Interest = Principal* Rate* Time
	}
}
