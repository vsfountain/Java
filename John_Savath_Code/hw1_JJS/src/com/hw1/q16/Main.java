/**
 * 
 */
package com.hw1.q16;

/**
 * @author JohnJosephSavath
 *
 *Q16. Write a program to display the number of characters for a string input. 
 *The string should be entered as a command line argument using (String [ ] args).
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("This is my string input: "+args[0]+ " " + args[1]);
		
		int count = 0;
		System.out.println("Number of args: "+args.length);
		
		for(int i = 0; i<args.length;i++) {
			for(int j = 0; j<args[i].length(); j++) {
				count++;
			}
		}
		System.out.println("Number of characters: "+count);
	}

}
