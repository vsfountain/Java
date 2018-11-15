package com.example.abstraction;

//An interface is a contract.
//		implementing an interface creates a contract between
//		the interface and class.
public interface Edible /*extends Matter*/{
	public static final int number=0;
	
	/*public static void method1() {
		System.out.println(number);
	}*/
	
	Object scent();
	void burn();
	void freeze();
	default void method2() { //default keyword allows implementation
		System.out.println("hello");
	}
}
