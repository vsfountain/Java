package com.revature.abstracts;

public abstract interface OperatingSystem {
	/*
	 * 	Interfaces are Contracts
	 * 		Classes use the keyword "implements"
	 * 		Methods are abstract by default (implicit)
	 * 		Methods can concrete by using the default keyword
	 * 		State is implicitly "public static final"
	 */
	
	public final static boolean isWorking = false;
	boolean alsoWorking = true; //still public static final
	
	public void installWindows(); //abstract is implicit
	  
	//introduced in 1.8  
	public default void concreteMethod(){
		System.out.println("concrete method in an interface");
	}
}
