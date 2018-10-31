package com.example.q19;

import java.util.ArrayList;

public class q19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Integer> a = new ArrayList<>();
		
		
		for(int i = 0; i<10; i++) {
			
			a.add(i + 1);
			
			
		}
		
		int count = 0;
		for(int i = 0; i<a.size(); i++) {
			if(a.get(i) % 2 == 0) {
				count = count + a.get(i);
			}
		}
		System.out.println(count);
		
		count = 0;
		
		for(int i = 0; i<a.size(); i++) {
			if(a.get(i) % 2 == 1) {
				count = count + a.get(i);
			}
		}
		System.out.println(count);
		int aaa = a.size();
		int c = 0;
		for(int i = 0; i<aaa; i++) {
			if(isP(a.get(i - c))) {
				a.remove(i - c);
				c +=1;
			}
			
		}
		System.out.println(a);
		
	}
	
	public static boolean isP(int a) {
		boolean p = true;
		for(int i = 2; i<a; i++) {
			if(a % i == 0) {
				p = false;
			}
		}
		/*if(p) {
		System.out.print(a + " ");
		}*/
		return p;
	}

}
