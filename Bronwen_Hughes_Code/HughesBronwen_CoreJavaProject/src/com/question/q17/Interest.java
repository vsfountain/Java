package com.question.q17;

import java.util.Scanner;

public class Interest {
	private static int principal;
	private static double rate;
	private static int years;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter principle:");
		principal = scan.nextInt();
		
		System.out.println("Please enter rate:");
		rate = scan.nextDouble();
		
		System.out.println("Please enter years:");
		years = scan.nextInt();
		
		
		System.out.println(principal + " * " + rate + " * " + years + " = " + Calculate());
	}
	
	public static double Calculate() {
		return principal*rate*years;
	}
	
	
}
