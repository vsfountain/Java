package com.example.classbehavior;

/*
 * Scopes of a variable in java:
 * 
 * 		static/class - exists within the class itself
 * 		instance/object -	only exists within the object
 * 				each object has its own state.
 * 		local/method- only exists within the specific method
 * 		block- only exists within the specific block
 */

class Vehicle{
	public int a= 17;
	
	public Vehicle() {
		System.out.println("in my parent!");
	}
}

class Car extends Vehicle {
	public int a= 34;
	static String color;
	String model;
	String make;
	
	//if no other constructor is created, then the compiler gives you a default
	//	constructor. the default constructor happens to be a no-args constructor
	Car() { 	//this is a no args constructor
		//this("red");
		super();
	}
	
	Car(String color) { //this is an args constructor
		this(color, "mustang", "ford");
	}
	
	Car(String color, String model, String make){
		this();
		this.color=color;
		this.model=model;
		this.make=make;
		System.out.println(" Hey look at me!");
	}
	
	void printCar() {
		System.out.println("Color: "+ this.color +
							"     model: "+ this.model +
							"     make: "+ this.make);
		System.out.println(a);
	}
	
	void methodOne() {
		int ij= 15;
		System.out.println(ij);
		
		boolean b=true;
		if(b) {
			int j=5;
		}
		//System.out.println(j);
	}
	
}
