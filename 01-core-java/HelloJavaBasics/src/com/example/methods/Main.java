package com.example.methods;

public class Main {

	static void methodOne(int numba) {
		numba= numba*2;
		numba=numba+3;
		System.out.println(numba);
	}
	
	public static void main(String[] args) {

		int num= 2;
		
		methodOne(num);
		methodOne(num);
		//17 more times
		
		/*num= num*2;
		num= num+3;
		System.out.println(num);
		
		num= num*2;
		num= num+3;
		System.out.println(num);
		//continued 17 more times.
*/		
		//we need to modularize the code to defeat redundancy
	}
	
	

}
