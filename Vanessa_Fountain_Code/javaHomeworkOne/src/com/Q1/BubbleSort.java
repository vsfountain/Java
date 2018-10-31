package com.Q1;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array1 = {1,0,5,6,3,2,3,7,9,8,4};
		for(int i = 0; i < array1.length; i ++){
			//System.out.println(array1[i]);
			for(int j = 0; j < array1.length; j ++) {
				//System.out.println(array1[j]);
				if (array1[i] < array1[j]) {
					int temp = array1[i];
					array1[i] = array1[j];
					array1[j] = temp;
				}
			}
		}
		for(int k = 0 ; k < array1.length; k ++) {
			System.out.println(array1[k]);
		}
	}
}