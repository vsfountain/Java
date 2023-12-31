package com.example.classbehavior;

/*Naming conventions of java
 * 
 * variable names:
 * 		camel case.  e.g. myFirstName, myLastName
 * class names:
 * 		title case, and a noun . e.g. Animal, UserStory, Button
 * interface names:
 * 		title case, and a adjective. e.g. Runnable, Comparable
 * method names:
 * 		camel case, and a verb.  e.g. drawRectangle, run
 * package names:
 * 		lowercase.   e.g. java, lang, sql, util, etc
 * constants:
 * 		uppercase.  e.g. RED, YELLOW, MAX_PRIORITY, etc
 * 
 * 
 */


public class Main {

	public static void main(String[] args) {
		new Animal();	//simplest way to create an object
		
		Animal x= new Animal();
		
		//is there a constructor? is this calling the constructor?
		//Car daCar= new Car("Cosmic Blue", "Civic", "Honda");
		//daCar.printCar();
		
		Car a= new Car("blue");
		
		a.printCar();
	}

}
