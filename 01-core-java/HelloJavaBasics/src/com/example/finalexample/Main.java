package com.example.finalexample;
/*
 * What does the final keyword do?
 * 		will not let you modify a variable's value
 * 
 * 	on a variable- it's value cannot be altered
 * 	on a method-	it cannot be overridden
 * 	on a class-		it cannot be extended
 */
public class Main {

	static final int MAX_NUM=57;
	
	public static void main(String[] args) {
		System.out.println(MAX_NUM);
		//MAX_NUM=5; 	//will produce an error
		System.out.println(MAX_NUM);
		
	}

}
