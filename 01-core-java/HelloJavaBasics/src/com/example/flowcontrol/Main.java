package com.example.flowcontrol;

public class Main {

	public static void main(String[] args) {

		//What is flow control?
		//		if statements, loops, try catch blocks, etc
		
		//&& and || are short circuited operators
		// & and | are not
		int i= 0;
		if(i>-1 || method1()) {
			System.out.println("inside if statement");
		}else {
			System.out.println("inside else statement");
		}
		
		System.out.println("done");
	}
	
	public static boolean method1() {
		System.out.println("    inside method 1");
		return true;
	}

}
