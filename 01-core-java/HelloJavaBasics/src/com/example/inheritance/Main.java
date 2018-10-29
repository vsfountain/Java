package com.example.inheritance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal an = new Animal();
		Monkey monk = new Monkey();
		
		Monkey monkey = new Monkey();
		Animal tempAnimal = new Monkey();
		
		Object obj = an.height;
		System.out.println(obj);
		
		System.out.println(obj);
		
		/*upcasting
		 * will use overridden methods in monkey but is searching for members in Animal
		 * Cannot override a variable, can only shadow it.
		*/
		tempAnimal.speak(); 
		an.speak();
		System.out.println(((Monkey)tempAnimal).color);
		System.out.println( (Animal)monkey );
		System.out.println(obj);
	}

}
