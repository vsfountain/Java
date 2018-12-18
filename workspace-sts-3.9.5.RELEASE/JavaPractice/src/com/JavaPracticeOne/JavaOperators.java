package com.JavaPracticeOne;

import java.util.Scanner;

/**
 * ➢Write a program to add, subtract, multiply and divide two non zero
 * hard-coded numbers. ➢Write a program to search for the greatest of three
 * numbers using Short-circuit Operators and print the result.
 *  ➢Write a program
 * –declare two variables a and b and initialize them to true and false
 * respectively. Get the output of the following computations: !a a | b (!a & b)
 * | (a & !b)
 * 
 * @author Kristen Kavanagh
 *
 */
public class JavaOperators {

	public static void main(String[] args) {
		// inputArithmeticOperators();
		// arithmeticOperatorsHardCodedValues();
		// largestUsingTernaryOperator();
		twoVariablesboolean();
	}

	public static void inputArithmeticOperators() {
		// not hard coded numbers
		Scanner in = new Scanner(System.in);
		System.out.println("Input first number:");
		int num1 = in.nextInt();

		System.out.println("Input second number:");
		int num2 = in.nextInt();

		System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
		System.out.println(num1 + "-" + num2 + "=" + (num2 - num1));
		System.out.println(num1 + "*" + num2 + "=" + (num2 * num1));
		System.out.println(num2 + "/" + num1 + "=" + (num2 / num1));
	}

	public static void arithmeticOperatorsHardCodedValues() {

		int price = 8;
		int quantity = 19;

		System.out.println(price + "+" + quantity + "=" + (price + quantity));
//	System.out.println(n + "-" + n + "=" + (num2-num1));
//	System.out.println(num1 + "*" + num2 + "=" + (num2 * num1));
//			System.out.println(num2 + "/" + num1 + "=" + (num2/num1));

	}

public static void largestNumbersUsinglogicalOperator() {
	int apples =0;
	int bananas = 0;
	int oranges = 0;
	int mostExpensive = 0;
	Scanner price = new Scanner(System.in);
	System.out.println("Enter the price of apples: ");
	apples = price.nextInt();
	System.out.println( "Enter the price of bananas: ");
	bananas = price.nextInt();
	System.out.println("Enter the price of Oranges:");
	oranges = price.nextInt();
	if (apples>bananas && apples>oranges) {
		System.out.println(" apples are EXPENSIVE" + apples);
	 mostExpensive = apples;
	}
	 else if(bananas>apples && bananas>oranges) {
		 mostExpensive = bananas;
	 }else { 
		 mostExpensive = oranges;
	System.out.println("The most Expensive Fruit is:" + mostExpensive);
	
	
}
}
public static void  largestUsingTernaryOperator() {
	int apples = 7;
	int bananas = 34;
	int oranges = 22;
	int largestValue = 0;
			//int largest = (apples>bananas&&apples>oranges)?apples:(bananas>oranges&&bananas>oranges)?bananas:oranges;
	
}
/**
 * Write a program
 * declare two variables a and b and initialize them to true and false
 * respectively. Get the output of the following computations: !a 
 *  a | b 
 *  (!a & b) | (a & !b)
 */
public static void twoVariablesboolean() {
	boolean a = true;
	boolean b = false;
	System.out.println(!a);
	System.out.println(a|b);
	System.out.println((!a & b) | (a & !b));
}

}