package com.example.inheritance;

public class Monkey extends Animal {
	boolean hair= true;
	boolean thumbs= true;
	String color;
	static String fingers;
	
	void countFingers() {
		//String fingers;
		//System.out.println("om nom nom");
		System.out.println(fingers);
	}
	
	@Override  //annotation
	void speak() {
		System.out.println("   Make Monkey noises!");
		
	}
	@Override
	  public String methodTwo(){	//covariant return types
	  		return color;
	  }
	
	  
	 
}
