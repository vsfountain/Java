package com.example.classbehavior;

//this is a class
// a class is a blueprint for an object.
//	object is an instance of a class
public class Animal {
	//how do we give an object state?
	int speed= 15;
	String color="red";
	boolean isAlive;
	
	//how do we give an object behavior?
	void walk() {
		speed= speed+15;
	}
	
	void mortality() {
		isAlive= !isAlive;
	}
	
}
