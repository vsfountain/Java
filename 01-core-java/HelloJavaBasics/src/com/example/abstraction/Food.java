package com.example.abstraction;
/*
 * Differences between abstract class and interfaces:
 * 		interface					abstract
 * -----------------			------------------
 * uses "implements"				"extends"
 * multiple inheritance				single inheritance
 * methods implicitly:				no implicit modifiers
 * 		abstract and public
 * variables implicitly:
 * 		public, static, final
 * BUT you can have static methods
 * Cannot have a constructor		DOES have a constructor
 * 
 * pros and cons of using interface:
 * ------------------------------------
 * pro: can implement multiple
 * con: cannot implement non-static method
 * 		(until java 8 and the "default" keyword)
 * con: no instance variables
 * con: no constructor
 * 
 * 
 */
public abstract class Food {
	 
	String color;
	static int temperature;
	String quality= "good";
	
	public Food() {
		temperature=70;
		color="";
	}
	
	void goBad() {
		quality="rotten";
	}
	
	abstract void cook();
}
