package com.example.object;

public class MyObj {
	public static void main(String[] args) {
		Object obj = new Object();
		
		//System.out.println() calls this method
		obj.toString(); //we know this one already
		obj.equals(obj); //compares memory address, until we override
		obj.hashCode();
		
		
		DummyObject one= new DummyObject();
		DummyObject two= new DummyObject();
		System.out.println(one.hashCode());
		System.out.println(two.hashCode());
		
		
		//equals demo
		/*DummyObject one= new DummyObject();
		DummyObject two= new DummyObject();*/
		/*String one= new String("hello");
		String two= new String("hello");*/
		
		/*System.out.println(one);
		System.out.println(two);*/
		/*System.out.println(one==two);
		System.out.println(one.equals(two));*/
	}
}
