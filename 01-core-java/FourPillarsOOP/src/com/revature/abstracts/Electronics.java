package com.revature.abstracts;

public abstract class Electronics extends Object {

	/*
	 * 	abstract - characteristics
	 * 	Abstract Class & Interfaces cannot be instantiated		
	 * 	methods can be concrete or abstract
	 * 	blueprints for subclasses
	 * 
	 *  Concrete Methods = has a body/defined/implemented/braces/
	 *  
	 *  Abstract methods = no body/no {}, 
	 * 	
	 * 	protected is used a lot with abstract classes
	 * 	No restrictions on access modifiers for state(variables)
	 */
	
	protected boolean canIBePrivate;
	
	//no-args
	public Electronics() {
		System.out.println("Building a Electronics object");
	}
	
	public void chargeUp(){
		System.out.println("Electronics being charged up");
	}

	//abstract methods
	public abstract void onStartProcess();
}
