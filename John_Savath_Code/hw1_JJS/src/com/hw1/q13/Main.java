/**
 * 
 */
package com.hw1.q13;

/**
 * @author JohnJosephSavath
 *
 *Q13. Display the triangle on the console as follows using any type of loop.  
 *Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for (int i = 0; i<1; i++) {
			System.out.println("0\n");
			for (int j = 0; j<1; j++) {
				System.out.println("1 0\n");
			} for (int k = 0; k<1; k++) {
				System.out.println("1 0 1\n");
				for(int l = 0; l<1; l++) {
					System.out.println("1 0 1 0\n");
				}
			}
		}*/
		
		
		
		
		/*
		 * 0
		 * 1 0
		 * 1 0 1
		 * 0 1 0 1
		 */
		String lastChar = "1";
		for(int i = 0; i<5; i++) {
			
			for(int j = 0; j<i; j++) {
				if(lastChar.equals("0")) {
					System.out.print("1 ");
					lastChar = "1";
				} else {
					System.out.print("0 ");
					lastChar = "0";
				}
				
				
			}
			System.out.println();
			
			
		}
		
		
	}

}
