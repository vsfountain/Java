/**
 * 
 */
package com.hw1.q19;

import java.util.ArrayList;

/**
 * @author JohnJosephSavath
 *
 *Q19. Create an ArrayList and insert integers 1 through 10. 
 *Display the ArrayList. 
 *Add all the even numbers up and display the result. 
 *Add all the odd numbers up and display the result. 
 *Remove the prime numbers from the ArrayList 
 *and print out the remaining ArrayList.
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int addEven;
		int addOdd;
		int results;
		
		ArrayList<Integer> arl=new ArrayList<Integer>();
		arl.add(1);//prime number
		arl.add(2);//prime number
		arl.add(3);//prime number
		arl.add(4);
		arl.add(5);//prime number
		arl.add(6);
		arl.add(7);//prime number
		arl.add(8);
		arl.add(9);
		arl.add(10);
		int i = 0; // Index 0 is of the first element
		
		//This prints out all the numbers in the arraylist
		System.out.println("Arraylist contains: " + arl.toString());
		
		addEven = arl.get(1) + arl.get(3) + arl.get(5) + arl.get(7) + arl.get(9);
		System.out.println("The sum of all the even numbers are: "+addEven);
		
		addOdd = arl.get(0) + arl.get(2) + arl.get(4) + arl.get(6) + arl.get(8);
		System.out.println("The sum of all the odd numbers are: "+addOdd);
		
		arl.remove(0);
		arl.remove(0);
		arl.remove(0);
		arl.remove(1);
		arl.remove(2);
		
		System.out.println("After the prime numbers are removed: " + arl.toString());
		
	}

}
