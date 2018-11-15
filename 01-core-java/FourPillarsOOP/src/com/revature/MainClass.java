package com.revature;

import com.revature.abstracts.OperatingSystem;
//ctrl + shift + o = organizing import
import com.revature.pojo.Computer;
import com.revature.pojo.Laptop;

public class MainClass {
	/*
	 *  4 Pillars OOP
	 *  	Abstraction - blackbox inputs and outputs but not the implementation
	 *  	Polymorphism - many forms, overriding and overloading, parent reference = child instance 
	 *  	Inheritance - child class recodes from parent class
	 *  	Encapsulation - strict random access
	 *  
	 *  Inheritance:
	 *  	classes extends classes
	 *  		-only 1 class
	 *  	classes implements interfaces
	 *  		-many separated by ,
	 *  	
	 *  	interfaces extends interfaces
	 *  		-many!
	 *  	
	 *  
	 *  
	 *  Vocabulary:
	 *  implicit vs explicit 
	 *  POJO - plain old java object
	 *  JavaBean - same as POJO but strict requirements 
	 *  object = instance (instantiate objects only, not primitives)
	 *  keywords vs reserved words = keyword are implemented, reserved might be in the future but not currently
	 *  
	 *  Scopes of Java variables
	 *  	local aka block - between {}
	 *  	method aka parameter
	 *  	instance aka object 
	 *  	class aka static  
	 *  
	 *  Final / Static Keywords 
	 *  static members don't get inherited
	 *  
	 */
	public static void main(String[] args) {

//		new MainClass().shortCut(); //shortCut() is non-static, must have an instance of it to access
//		localScope();	//localScope() is static, I can directly access without an instance
//		encapsulation(); //example of encapsulation and why we want to "restrict random access"
		
		//is-a rule 
		//left side = object reference
							//right side is the object instantiation 
		Laptop awesomeLaptop = new Laptop();
		Computer l2 = awesomeLaptop; //upcasting -implicit, compiler doesn't care
		Object l3 = awesomeLaptop;
		
		OperatingSystem os = new Computer();
		OperatingSystem os1 = new Laptop();
		
//		((Laptop)l3).getBatteryLife(); down casting - explicit, developer telling compiler I know what I am doing
		
//		System.out.println(awesomeLaptop);

	}
	
	  OperatingSystem windows = new OperatingSystem() {
          @Override
          public void installWindows() {
              // TODO Auto-generated method stub
              
          }
          @Override
          public void concreteMethod() {
              // TODO Auto-generated method stub
              OperatingSystem.super.concreteMethod();
          }
      };
	
	
	public void shortCut(){
		System.out.println("ctrl + / = comment/uncomment");
		System.out.println("ctrl + shift + o = organizing import");
		System.out.println("ctrl + d = delete line");
		System.out.println("ctrl + shift + f = auto format");
	}
	
	public static void localScope(){
		int x = 0;
		if (x < 1000) {
			int i = 10;
			x = 10;
			System.out.println(x);
		} 
		System.out.println(x); //x is local to the top of the method
//		System.out.println(i); i is local to if statement
	}

	public static void encapsulation(){
		Computer c1 = new Computer();
		Computer c2 = new Computer();
		
		c1.setName("Bobbert");
//		c1.id = 1000; -bad practice
		c1.setId(10);
		c2.setName("John");
		
		System.out.println(c1.toString()); //toString is implicit
		System.out.println(c2);

		System.out.println(Computer.brand); //public static member
		System.out.println(Computer.getSecretChip());
	}
	
	
	public void stringImmutatable(){
	//Immutatable object will create a new object with every change
		String s = "hello";
		System.out.println(s);
		s = s.concat(" world"); //s must be reassigned or the change won't be reflected
		System.out.println(s);
	}
	
}
