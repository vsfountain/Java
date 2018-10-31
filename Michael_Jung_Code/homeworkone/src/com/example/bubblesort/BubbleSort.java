package com.example.bubblesort;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,0,5,6,3,2,3,7,9,8,4};
		
		for(int i = 0; i<a.length; i++) {
			int k = 0;
			for(int j = 1; j<a.length - i ; j++) {
				
			if(a[k]>a[j]) {
				int x = a[k];
				a[k] = a[j];
				a[j] = x;
			}
			k++;
		}
			
		}
		for(int aa: a) {
			System.out.print(aa);
		}
	}

}
