package com.homework.question19;

import java.util.*;
public class ArrayListIntegers {

	public static void main(String[] args) {
		ArrayList<Integer> myArrayList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			myArrayList.add(i+1);
		}
		int addEvens = 0;
		for(int i = 1; i < 10; i+=2) {
			addEvens += myArrayList.get(i);
		}
		System.out.println("All the evens add up to: " + addEvens);
		
		int addOdds = 0;
		for(int i = 0; i < 10; i+=2) {
			addOdds += myArrayList.get(i);
		}
		System.out.println("All the odds add up to: " + addOdds);
		
		for(int i=0; i < myArrayList.size(); i++) {
			if(myArrayList.get(i)==2 || myArrayList.get(i)==3 || myArrayList.get(i)==5 || myArrayList.get(i)==7) {
				myArrayList.remove(i);
				i--;
			}
		}
		System.out.println("The arrayList without prime numbers is: " + myArrayList);
	}

}
