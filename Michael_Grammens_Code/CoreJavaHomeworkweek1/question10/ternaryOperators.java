package com.homework.question10;

import java.util.*;

public class ternaryOperators {
	public static void main(String[] args) {
		System.out.println("Enter two numbers seperated by a space");
		Scanner input = new Scanner(System.in);
		try {
			int firstInt = input.nextInt();
			int secondInt = input.nextInt();
			System.out.print("The smaller number is: ");
			System.out.println(firstInt>secondInt ? secondInt:firstInt);
		}
		catch(Exception e){
			System.out.println("Thats the wrong input, try again please with an int followed by an int");
		}
		input.close();
	}
}
