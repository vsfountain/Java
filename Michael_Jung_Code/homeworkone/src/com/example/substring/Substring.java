package com.example.substring;

public class Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String a = substring("ldskflskd", 3);
		
		
		System.out.println(a);
		
	}

	
	
	public static String substring(String str, int idx) {
		
		String a = "";
		
		for(int i = 0; i< idx; i++) {
			a = a + str.charAt(i);
		}
		
		return a;
		
		
		
	}
}
