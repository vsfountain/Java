package com.homework.question9;

import java.util.*;
public class ArrayListPrimes {
	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for(int i = 0; i<100; i++) {
			myList.add(i+1);
		}
		ArrayList<Integer> primeList = new ArrayList<>();
		primeList.add(2);
		int checkCondition = 0;
		for(int i = 0; i < myList.size();i++) {
			for(int j = i-1; j > 0; j--) {
				if(myList.get(i)%myList.get(j)!=0) {
					//primeList.add(myList.get(i));
					checkCondition = 1;
				}else if(myList.get(i)%myList.get(j)==0){
					checkCondition = 0;
					break;
				}
			}
			if(checkCondition == 1) {
				primeList.add(myList.get(i));
			}
		}
		System.out.println("All prime numbers are: " + primeList);
	}
}
