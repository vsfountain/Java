package com.revature.pojo;

import java.io.Serializable;

import com.revature.abstracts.Electronics;
import com.revature.abstracts.OperatingSystem;

//pojo - plain old java object
public class Computer extends Electronics implements OperatingSystem, Serializable{

	/*
	 * Plain Old Java Object -state -behavior -no args constructor -overriden
	 * toString
	 */
	// state - variables
	private String name; // object's default value are null
	private int id; // e.g. id's can't be under 1000
	
	/*
	 * Static has nothing to do with the Objects!
	 * Static does mean it won't change but what is the it? - memory location, not the value at that location
	 * 
	 * IQ
	 * How do I access static members? - the class name and the dot operator . e.g. Computer.brand or Computer.getSecretChip()
	 * 
	 */
	public static String brand = "Awesome"; //public example
	/*
	 * 	Final Keyword - IQ
	 * 		variables - constant, can't change
	 * 		methods - cannot override a final method, but it is still inherited
	 * 		classes - can't be subclass, e.g. of a final class - String and Wrapper Classes
	 */
	private final static String secretChip = "i9000";
	
	
	// //no-args
	public Computer() {
		super(); //object's constructor
		System.out.println("Building a Computer");
	}

	// Overload my construtor
	public Computer(int a) {
		System.out.println(a);
	}

	// Behavior - methods
	public String getName() {
		return name;
	}

	// Shadowing = parameter has the same name as instance variable
	public void setName(String name) {
		System.out.println("Computer's name is: " + this.name);
		this.name = name;
	}

	//instance method, can it access static members? 
	public int getId() {
		System.out.println(secretChip);
		return id;
	}

	public void setId(int id) {
		int x = 0;
		if (id < 1000) {
			x = 10;
			System.out.println(x);
			System.out.println("id can't be less than 1000");
		} else {
			this.id = id;
		}
		System.out.println(x);
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", id=" + id + "]";
	}

	public static String getSecretChip() {
		System.out.println("static methods can't access non-static/instance members");
		System.out.println("but i can access static members " + secretChip);
		return secretChip;
	}

	@Override
	public void onStartProcess() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void installWindows() {
		System.out.println("installing windows");
		
	}
	
//	can't use the assignment operator (=) on a final variable
//	public static void setSecretChip(String secretChip) {
//		Computer.secretChip = secretChip;
//	}

}
