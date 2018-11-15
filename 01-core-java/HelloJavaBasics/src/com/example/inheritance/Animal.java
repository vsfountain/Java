package com.example.inheritance;

public class Animal {
	boolean isAlive= true;
	protected int height;
	int weight;
	String color="red";
	
	void speak() {
		System.out.println("Make animal noises!");
	}
	
	public Object methodTwo() {
		return color;
	}
}
