package com.example;

public interface MyInterface {
	int k=0;
	
	//static method
	 public static void staticPrinter(){
	  		System.out.println("in static printer");
	 }
	 
	//abstract
	void printer(String s);
	
	//a default method
	public default void defaultPrinter() {
		System.out.println("in default printer");
	}
}
