package com.example.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * You're able to use generics with methods:
 * 		public static <T> void method1(T variable) { T.itsMethod(); }
 * 
 * yo're able to use generics like:
 * 		public static <T, J> void .....blah blah
 * 		public static <wholeWord, Other word> void .....blah blah
 * 
 * 	YOu're also able to use genrics this way:
 * 		public static <T extends Runnable> void method2() {}
 */

class GenericClass<Kite extends Serializable>{
	private Kite value;
	
	public GenericClass(Kite value) {
		this.value= value;
	}
	
	public Kite getValue() {
		return value;
	}
}

public class Main {

	public static void main(String[] args) {
		GenericClass<String> firstExample= new GenericClass<String>("hello");
		//GenericClass<Integer> gen= new GenericClass<Integer>(5);
		
		//GenericClass<Object> gen= new GenericClass<Object>(5);
		
		//you don't need to put anything inside of brackets on right side
		//GenericClass<Object> gen= new GenericClass<>("");
		
		//this is bad practice, we want to use diamond brackets for
		//	compile time safety
		GenericClass gen= new GenericClass("stuff");
		
		System.out.println(gen.getValue());
		System.out.println(gen.getValue() instanceof Integer);
	}

	/*void method1(String var) {
		//my logic, 34 lines of code
	}
	void method1(Thread var) {
		//my logic (same general logic as above)
	}
	void method1(ArrayList var) {
		//the same logic again
	}
	void method1(HashSet var) {
		//same logic again
	}
	//six more methods using this pattern
*/}
