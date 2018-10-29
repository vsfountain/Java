package com.homework.question4;

import java.util.*;
public class nfactorial {
	public static void main(String[] args) {
		System.out.println("Enter your n!");
		Scanner n = new Scanner(System.in);
		try {
			int nFac = n.nextInt();
			if(nFac == 0) {
				System.out.println("1");
			}
			else {
				int factorialThis = 1;
				for(int i = nFac; i > 1; i--) {
					factorialThis*=i;
				}
				System.out.println(factorialThis);
			}
		}
		catch(Exception e){
			System.out.println("Thats the wrong input, try an integer please.");
		}
		n.close();
	}
}
