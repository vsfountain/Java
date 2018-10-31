package com.example.reflection;

import com.example.object.DummyObject;
/*
 * reflection allows one to view an object or primitive during runtime
 * 		you may also modify
 */
public class Main {

	public static void main(String[] args) {

		//com.example.object.DummyObject dum= new com.example.object.DummyObject();
		
		DummyObject dum= new DummyObject();
		
		Class reflect= dum.getClass();
		
		System.out.println(reflect.getName());
		System.out.println(reflect.isPrimitive());
		System.out.println(reflect.getSuperclass());
		System.out.println(reflect.getModifiers());
		
		System.out.println(dum instanceof DummyObject);
	}

}
