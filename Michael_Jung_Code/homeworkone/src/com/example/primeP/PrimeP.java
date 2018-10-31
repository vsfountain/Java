package com.example.primeP;

import java.util.ArrayList;

public class PrimeP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 0; i<100; i++) {
			a.add(i + 1);
		}
		for(int i = 0; i<100; i++) {
			if(i == 0) {
				System.out.print("1 ");
			} else if (i == 1) {
				System.out.print("2 ");
			}else {
				isP(a.get(i));
			}
		}
	}
	
	public static void isP(int a) {
		boolean p = true;
		for(int i = 2; i<a; i++) {
			if(a % i == 0) {
				p = false;
			}
		}
		if(p) {
		System.out.print(a + " ");
		}
		
	}

}
