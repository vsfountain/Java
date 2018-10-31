package com.example.q3;

public class q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "asdf";
		int aa = a.length();
		for(int i = 0; i<aa; i++) {
			
			a = a + a.charAt(aa -(i+1));
			
			
			
		}
		//System.out.println(a);
		a = a.substring(a.length()/2, a.length());
		
		
		System.out.println(a);
		
		
	}

}
