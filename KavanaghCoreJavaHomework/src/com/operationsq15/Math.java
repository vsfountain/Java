package com.operationsq15;

import java.util.Scanner;

public class Math implements operationsinterface {

	public Math() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void additionOperation() {
		int x, y, z;
		  
	      System.out.println("Enter two integers to calculate their sum");
	      Scanner in = new Scanner(System.in);
	     
	      x = in.nextInt();
	      y = in.nextInt();
	      z = x + y;
	     
	      System.out.println("Sum of the integers = " + z);
		
	}

	@Override
	public void subtractionOperation() {
		int counter = 15;
		counter = counter - 1;
		System.out.println("Subtraction = " + counter);
		
		
	}

	@Override
	public void multiplicationOperation() {
		int x = 12;
		int y = 13;
		int z = x * y;
		System.out.println("Multiplication: " + z);
	}

	@Override
	public void divisionOperation() {
		Scanner input = new Scanner (System.in);
	    System.out.print("Input the first number: ");
	    int a = input.nextInt();
	    System.out.print("Input the second number: ");
	    int b = input.nextInt();
	    int d = (a/b);
	    System.out.println();
	    System.out.println("The division of a and b is:" +d);
		
	}

}
