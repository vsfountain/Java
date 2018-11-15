package com.example.garbage;

public class Main {

	static Object o;
	
	public static void main(String[] args) {

		Object obj;
		Object obj2=new Object();
		Object obj3=new Object();
		
		obj= obj3;
		
		obj3=null;
		obj2=null;//eligible for garbage collection, not immediate
		
		System.gc();
		
		//the garbage collector will call the finalize method just before
		//	deallocating your object.
		//finalize();
	}

}
