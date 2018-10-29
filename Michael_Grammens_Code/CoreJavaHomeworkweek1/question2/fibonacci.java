package com.homework.question2;

import java.util.*;

public class fibonacci {
	public static void main(String[] args) {
		int[] fibNumba = new int[25];
		fibNumba[0] = 0;
		fibNumba[1] = 1;
		fibNumba[2] = 1;
		for(int i = 3; i < fibNumba.length; i++) {
			fibNumba[i] = fibNumba[i-2]+fibNumba[i-1];
		}
		System.out.println(Arrays.toString(fibNumba));
	}
}
