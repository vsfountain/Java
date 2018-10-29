package com.example.inheritance;

public class Animal {
	boolean isAlive = true;
	int height;
	int weight;
	String color = "Red";
	
	
//covariant return types
	
	void speak() {
		System.out.println("Make Animal Noises");
	}

}
