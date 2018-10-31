package com.javahomework.questions15;

public class Main{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorImplementation c = new CalculatorImplementation();
		System.out.print("1 + 2 = ");
		System.out.println(c.add(1, 2));
		
		System.out.print("10 - 2 = ");
		System.out.println(c.subtract(10, 2));
		
		System.out.print("8 x 5 = ");
		System.out.println(c.multiply(8,5));
		
		System.out.print("100 + 20 = ");
		System.out.println(c.divide(100,20));
	}



}
