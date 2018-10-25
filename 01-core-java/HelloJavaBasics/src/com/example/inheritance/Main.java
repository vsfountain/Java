package com.example.inheritance;

public class Main {

	public static void main(String[] args) {
		Animal animal= new Animal();
		Monkey monkey= new Monkey();
		
		Animal tempAnimal= new Monkey();	//this is a form of
											//	polymorphism
		//tempAnimal.speak();
		monkey.countFingers();
		/*animal.speak();
		monkey.speak();*/
		//System.out.println(( (Monkey)tempAnimal ).color);
		//tempAnimal.speak();
		
		//System.out.println((Monkey)tempAnimal);
		//System.out.println((Monkey)animal); //will cause runtime exception
		//System.out.println( (Animal)monkey);
		
	}

}
