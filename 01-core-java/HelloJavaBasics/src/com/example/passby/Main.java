package com.example.passby;

public class Main {

	public static void main(String[] args) {
		OurObject obj= new OurObject();
		
		methodOne(obj);
		
		System.out.println(obj.num);
		/*int i= 5;
		methodTwo(i);
		System.out.println(i);*/
		
	}

	public static void methodOne(OurObject obj) {
		obj.num= 15;
		obj= new OurObject();
	}
	public static void methodTwo(int numba) {
		numba= 15;
	}
}
