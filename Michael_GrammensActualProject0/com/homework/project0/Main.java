/*
 * Michael Grammens, 10/29/2018 Banking application
 * Not optimized at all. Only have pending and approved accounts as objects, while the rest was all crammed into 1 method
 * Lots of redundent code, should have planned much better before actually coding, but it wor
 * 
 */

package com.homework.project0;

public class Main {
	public static void main(String[] args) {
		RunProjectDao createObj = new RunProject();
		createObj.newAccount(); //Allowing us to re-ask for Customer, employee or admin without closing application.
	}
	
}
