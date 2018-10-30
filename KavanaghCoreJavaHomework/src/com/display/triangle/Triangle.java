package com.display.triangle;
/**
 * Display the triangle on the console as follows using any type of loop. Do NOT use
a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1
 * @author Kristen Kavanagh 
 * @version 10/29/2018
 *
 */

public class Triangle {



	public static void main(String[] args) {
	    int n=4; 
        for(int i = 0; i <= n; ++i)
        {
           for(int j = 0; j< i; j++)
              System.out.print((i+j) % 2 == 0 ? "1 " : "0 ");

            System.out.print("\n");
        }

     }
}
