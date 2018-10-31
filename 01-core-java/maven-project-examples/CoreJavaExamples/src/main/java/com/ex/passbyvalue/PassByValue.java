package com.ex.passbyvalue;

import com.pojos.Person;

public class PassByValue {
	
	public static void main(String[] args) {
		int x = 5;
		int y = 7;
		Person person = new Person("John", 29);
		System.out.println("x: " + x + "\ty: "+ y + "\tperson: " + person);
		x = example(x, y, person);
		System.out.println("x: " + x + "\ty: "+ y + "\tperson: " + person);
		
	}
	
	/*
	 * This shows how Java is PASS BY VALUE and not pass by reference
	 * 		Specifically the line: person = new Person("Amy", 35);
	 */
	static int example(int x, int y, Person person){
		x += 10;
		y += 10;
		person.setAge(30);				//change is reflected
//		person = new Person("Amy", 35);	//change is NOT reflected
		return x;
	}
	
}




