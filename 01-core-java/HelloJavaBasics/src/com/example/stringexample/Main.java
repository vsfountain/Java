package com.example.stringexample;

/*
 * A string is immutable. It means that a string cannot be changed.
 * 		Demonstrated by the fact that each string method returns a
 * 		reference to a new object, while the original string
 * 		doesn't change its value.
 */
public class Main {
	final String s=null;

	public static void main(String[] args) {

		Object o= new Object();
		
		//two ways to create strings
		String s= "this right here";
		String s2= new String("Hello World!!! XD");
		
		//s2.substring(4);
		
		//System.out.println(s2);
		
		/*System.out.println(5+""+3);
		System.out.println("78"+5+3);
		System.out.println(5+3+"78"+7+10);*/
		
		//string builder is mutable
		StringBuilder sb= new StringBuilder("Hello =)");
		sb.append("!");
		//System.out.println(sb);
		
		//stringbuffer is mutable, thread safe
		StringBuffer sbuff= new StringBuffer("Hello again...");
		sbuff.append("!");
		System.out.println(sbuff);
	}

}
