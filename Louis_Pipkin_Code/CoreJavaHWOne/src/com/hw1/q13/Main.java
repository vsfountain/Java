package com.hw1.q13;

public class Main {

	public static void main(String[] args) {
		/*
		 * 
		 * Question text
		 * 
		 * Q13. Display the triangle on the console as 
		 * follows using any type of loop. Do NOT use a 
		 * simple group of print statements to accomplish this.
		 * 
		 * 0
		 * 1 0
		 * 1 0 1
		 * 0 1 0 1
		 * 
		 */
		
		byte by = 0;
		
		//nested for loops because the firt level prints one time, the second two times, etc.
		for (int level=1; level<=4; level++) {
			for (int i=0; i<level; i++) {
				if (i==level-1) {	//This is so we don't have an trailing whitespace
					System.out.print(by);
				}else {
					System.out.print(by+" ");
				}
				//flip the bit
				if (by==0) {
					by = 1;
				}else {
					by = 0;
				}
			}
			System.out.println("");
		}
	
	}
	
}
