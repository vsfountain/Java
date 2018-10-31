package com.hw1.q11.p2;

public class Float2 {
	public Float b = 2.2f;//use public to make class visible to other package
	
	public void print() {
		com.hw1.q11.p1.Float1 a = new com.hw1.q11.p1.Float1();
		System.out.println("Variable from float2: "+b + "\n"+"Variable from float1: "+ a.a1);
	}
}
