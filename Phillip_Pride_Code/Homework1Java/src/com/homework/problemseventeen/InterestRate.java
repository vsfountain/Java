package com.homework.problemseventeen;
import java.util.*;
public class InterestRate {
	public static void main(String[] args) {
		int prin, rate, time;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your principle:");
		prin = input.nextInt();
		
		System.out.println("Please enter your rate of interest:");
		rate = input.nextInt();
		
		System.out.println("Please enter the number of years your interest has accumalated:");
		time = input.nextInt();
		
		System.out.println("Your total amount of interest is $" + prin*rate*time + ".");
		
	}

}
