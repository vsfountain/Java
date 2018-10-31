package com.example.q17;

import java.util.Scanner;

public class q17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String a = "Principal: ";
		String b = "Rate: ";
		String c = "Years: ";
		
		System.out.println(a);
		int aa = Integer.parseInt(sc.next());
		System.out.println(b);
		double aaa = Double.parseDouble(sc.next());
		aaa = aaa/100;
		System.out.println(c);
		int aaaa = Integer.parseInt(sc.next());
		
		System.out.println(aa * aaa * aaaa);
		
	}

}
