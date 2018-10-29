package com.example.abstraction;

public class Meatloaf extends Food implements Edible, Matter {
	public static void main(String[] args) {
		//Food food = new Food();// cannot be instantiated
		Food food = new Pizza();
		System.out.println(temp);
		System.out.println(Edible.temp);
	}

	@Override
	void goBad() {
		// TODO Auto-generated method stub
	
	}
	

	@Override
	void cook() {
		// TODO Auto-generated method stub
		int temperature = 85;
	}

	@Override
	public
	void scent() {
		// TODO Auto-generated method stub
		
	}

}
