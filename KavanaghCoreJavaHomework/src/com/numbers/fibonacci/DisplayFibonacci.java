package com.numbers.fibonacci;
/**
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

import java.util.Scanner;

// starting with o 
public class DisplayFibonacci {
  /** Main method */
	  public static void main(String[] args) {
	   
	    	Scanner s = new Scanner (System.in);
	    	int a = 0;
	    	int b = 1;
	    	int c;
	    	System.out.println("Enter 25");
	    	int n = s.nextInt();
	    	System.out.println(a+ ""+ b);
	    	for (int i =2; i < n; i++) {
	    		c = a + b;
	    		System.out.println("" + c);
	    		a=b;
	    		b=c;
	    	}}}