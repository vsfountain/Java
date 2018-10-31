package com.example.throwable;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * All exceptions are thrown at runtime.
 * 		If a checked exception isn't accompanied by a try/catch or ducked
 * 			it will CAUSE a syntax error.
 * 
 * Checked vs unchecked:
 * 		checked exceptions need to have a try/catch or be ducked.
 * 		unchecked exceptions don't have to be dealt with at compile time.
 * 		"who does this checking?". The compiler.
 * 
 */
public class Main {

	public static void main(String[] args){

		Object obj= new Object(); //cannot throw any ol' object
		//throw obj
		
		Throwable t= new Throwable();//checked
		//throw t;
		/*try {
			throw t;
		}catch(Throwable thro) {
			thro.printStackTrace();
		}*/
		
		//Exception e= new Exception(); //Exception is a checked exception
		//throw e;
		
		/*RuntimeException re= new RuntimeException();//unchecked exception
		throw re;*/
		
		/*Error err= new Error();
		try {
			throw t;
		}catch(Error ex) {
			System.out.println("I caught you!");
		}catch(Throwable th) {
			System.out.println("last resort");
			System.exit(0);
		}finally {
			System.out.println("in my finally block");
		}*/
		
		//method1();
		
		try {
			throw new MyException(
					"The exception was caused by dirty feet!",
					new IOException());
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		System.out.println("done");
	}
	
	public void method1() throws IOException,
			IndexOutOfBoundsException, FileNotFoundException{
		//using the "throws" keyword is called "ducking"
		
		throw new IOException();
		//six possible types of exceptions thrown
	}

}
