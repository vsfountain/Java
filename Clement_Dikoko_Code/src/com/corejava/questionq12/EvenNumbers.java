package com.corejava.questionq12;

import java.util.ArrayList;
/*Write a program to store numbers from 1 to 100 in an array.
 *Print out all the even numbers from the array.
 *Use the enhanced FOR loop for printing out the numbers.
 */
public class EvenNumbers {
	private static ArrayList <Integer> num = new ArrayList<>();
	
	private static void addValuesToOneHundred(){
		for(int i=0;i<100;i++) {
			num.add(i);
		}
	}
	
	public static void main(String[] args) {
		addValuesToOneHundred();
		for(Integer i : num) {
			if(i%2==0) System.out.println(i);
			else
				continue;
		}
	}
}
