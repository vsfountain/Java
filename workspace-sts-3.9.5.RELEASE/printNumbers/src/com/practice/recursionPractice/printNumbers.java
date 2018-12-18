package com.practice.recursionPractice;

/**
 * Print number from 5 to one 
 * @param num
 */
public class printNumbers {
	public static void main(String []args) {
		printNumbers(10);
		//2.cat eyes
		System.out.println("cat Eyes:" + catEyes(7));;
		
	}
	public static void printNumbers(int num) {
		if (num==0) {
			return;
		}
		else {System.out.println(num);
		printNumbers(num-1);
		
		}
			
	}
/**
 * We have cats and each have two eyes. Send the number of cats to a function
 * and return the total number of eyes all cats have.
 */
	public static int catEyes(int cats) {
		if(cats==0)
		{
			return 0;
		}else {
return 2 + catEyes(cats-1);	
		}
	}
	/**
	 * Find power by sending base and power value to a function.
	 * @param base
	 * @param num
	 * @return
	 */
	public static int power(int base, int num) {
		if(num==1) {
			return base;
		}else {
			return  base * power(base, num-1);
		}}
		
	}


