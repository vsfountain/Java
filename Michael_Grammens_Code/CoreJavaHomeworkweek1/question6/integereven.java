package com.homework.question6;

import java.util.*;

public class integereven {
	public static void main(String[] args) {
		System.out.println("Enter your integer, even or odd.");
		Scanner intEvenOrOdd = new Scanner(System.in);
		try {
			int isEven = intEvenOrOdd.nextInt();
			int Even = 2;
			while(isEven >= Even-2) {
				if(isEven == 1) {
					System.out.println("Odd");
					break;
				}
				else if(isEven-Even == 0) {
					System.out.println("Even");
					break;
				}
				else if(isEven-Even == 1) {
					System.out.println("Odd");
					break;
				}
				else {
					isEven-=2;
				}
			}
			while(isEven <= Even-2) {
				if(isEven == -1) {
					System.out.println("Odd");
					break;
				}
				else if(isEven+Even == 0) {
					System.out.println("Even");
					break;
				}
				else if(isEven-Even == -1) {
					System.out.println("Odd");
					break;
				}
				else {
					isEven+=2;
				}
			}
		}
		catch(Exception e){
			System.out.println("Thats the wrong input, try an integer please.");
		}
		intEvenOrOdd.close();
	}
}
