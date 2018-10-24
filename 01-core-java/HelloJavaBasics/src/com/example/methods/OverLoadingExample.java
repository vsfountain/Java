package com.example.methods;

public class OverLoadingExample {

	public static void main(String[] args) {
		//methodOne('u', 6);
		methodOne(6);
	}
	
	

	static void methodOne() {
		System.out.println("there are no arguments");
	}
	
	static void methodOne(char c) {
		System.out.println("there are no arguments, again");
	}

	// an overloaded method
	static void methodOne(int i) {
		System.out.println(i);
	}
	
	static void methodOne(int i, char j) {
		System.out.println(i+""+j);
	}
	
	static void methodOne(char i, int j) {
		System.out.println(i+""+j);
	}
	static void methodOne(char c, int... a) { //var args parameter list
		System.out.println("var args");
	}

	/*
	 * drawRectangle(int x, int y, int height, int length)
	 * drawRectangle(int x, int y, int height, int length, double alpha)
	 * 
	 */

}
