/**
 * 
 */
package com.hw1.q12;

import java.util.ArrayList;

/**
 * @author JohnJosephSavath
 *
 *Q12. Write a program to store numbers from 1 to 100 in an array. 
 *Print out all the even numbers from the array. 
 *Use the enhanced FOR loop for printing out the numbers.
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arl=new ArrayList<Integer>();
		
		for (int i = 0; i<101; i++) {
			arl.add(i);			
		}
		
		
		
		for (int numbers : arl) {//enhanced for loop

			if(numbers % 2 == 0 ) {
				System.out.print(numbers);
			}else {
				System.out.println(" ");
			}
			
		}

	}

}
