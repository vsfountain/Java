package com.example.palindromearraylist;

import java.util.ArrayList;

public class PalindromeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<>();
		a.add("karan");
		a.add("madam");
		a.add("tom");
		a.add("civic");
		a.add("radar");
		a.add("sexes");
		a.add("jimmy");
		a.add("kayak");
		a.add("john");
		a.add("refer");
		a.add("billy");
		a.add("did");
		
		ArrayList<String> b = new ArrayList<>();
		for(int i = 0; i<a.size(); i++) {
			String aa = "";
			for(int j = a.get(i).length() - 1; j>=0; j--) {
				aa = aa+ a.get(i).charAt(j);
			}
			if(aa.equals(a.get(i))) {
				b.add(aa);
			}
			
			
		}
		System.out.println(b.toString());

	}
	
	
	
	
	

}
