package com.simpleinterest;

import java.util.Scanner;

/**
 * program that calculates the simple interest on the principal, rate of interest
*and number of years provided by the user. Enter principal, rate and time through the
*console using the Scanner class.

*Interest = Principal* Rate* Time
 * @author Kristen Kavanagh
 * @version 10/29/2018
 *
 */

public class SimpleInterest {


		
	    public static void main(String args[]) 
	    {
	        float p, r, t;
	        Scanner s = new Scanner(System.in);
	        System.out.print("Enter the Principal : ");
	        p = s.nextFloat();
	        System.out.print("Enter the Rate of interest : ");
	        r = s.nextFloat();
	        System.out.print("Enter the Time period : ");
	        t = s.nextFloat();
	        float si;
	        si = (r * t * p) / 100;
	        System.out.print("The Simple Interest is : " + si);
	    }
	}

