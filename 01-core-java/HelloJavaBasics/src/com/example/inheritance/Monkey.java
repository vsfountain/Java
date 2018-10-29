package com.example.inheritance;

public class Monkey extends Animal {

		boolean hair = true;
		boolean thumbs = true;
		
		String color = "brown";// not being overridden, just being shadowed
		
		void eatBanana() {
			System.out.println("om nom nom");
		}
		
		@Override
		void speak() {
			System.out.println(height);
			System.out.println("Make Monkey Noises");
		}
}
