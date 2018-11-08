package com.example;

public class Main {

	public static void main(String[] args) {
		//we cannot instantiate an interface
		//MyInterface myInter = new MyInterface();
		
		//lambda
		//are a way to create a functional interface on the fly.
		
		//a lambda with multiple lines of code
		MyInterface myInter= (String s)->{ 
			int i=9;
			int j=7;
			System.out.println("in my printer: "+ i*j+" "+s);
			};
		myInter.printer("Trevin");
		
		//a lambda with one line of code
		MyInterface myInter2= (String s)->System.out.println("No curly"+s);
		myInter2.printer("Chester");
		myInter2.defaultPrinter();
		MyInterface.staticPrinter();
		System.out.println("K: "+MyInterface.k);
		
		//a lambda expression creates an instance of a functional
		// interface on the fly, using an anonymous method.
		Thread tee= new Thread( () -> {
			System.out.println("\tI'm in my runnable: "+
							Thread.currentThread().getName());
		});
		System.out.println(Thread.currentThread().getName());
		tee.start();
		
		
		//anonymous interface implementations
		//THESE ARE DIFFERENT FROM LAMBDAS
		MyInterface otherInter = new MyInterface() {
			private int otherNumber=7;
			
			@Override
			public void printer(String s) {
				System.out.println("in anonymous implementation");
			}
		};
		
		otherInter.printer("My Middle Name");
		
		OtherInterface dummy = new OtherInterface() {
			@Override
			public void printer2() {
			}
			@Override
			public void printer3() {
			}
		};
	}

}
