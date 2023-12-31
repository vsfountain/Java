package com.example.arrays;

public class ArrayExample {

	public static void main(String[] args) {

		/*
		 * What is an array?
		 * 
		 * it's a series of data entries (of the same type).
		 * For example, a series of characters.
		 */
		
		//how do we create an array?
		int[] arryOne= {15, 21, 37};  //also, "int arryThree[]= {15, 21, 37};" works
		int[] arryTwo= new int[11];
		boolean boolarry[]= new boolean[67];
		
		//how do we alter values in an array? Index starts at 0, NOT 1
		arryTwo[0]= 67;
		arryTwo[1]= 9;
		
		//System.out.println(arryTwo.length); //size of the array
		
		//what happens if I try to access an element that hasn't been initialized
		System.out.println(boolarry[2]);
		
		/*
		 * default values:
		 * 	boolean	false
		 * 	byte	0
		 * 	char	[null]
		 * 	int		0
		 * 	double	0.0d
		 * 	float	0.0f
		 * 	short	0
		 * 	long	0L
		 * 	object	[null]
		 */
		/*char c;
		System.out.println(c);*/
		
		
		
		////how do we create a multi dimensional array?
		int[][] arryThree= {{88,98}, {90,90}, {33,65}};
		int[][] arryFour= new int[3][2];
		
		arryFour[0][0]= 890;  //this is how we access elements in a 2D array
		
		//char arryFive[][][][][][][][][][][][][][][][][][][]= blah blah blah
		
		int[][] arryFive= new int[10][5];
		/*System.out.println(arryFive.length);
		System.out.println(arryFive[0].length);*/
		
		int[] arrySix= new int[2];
		arryFive[2]= arrySix;
		//System.out.println(arryFive[2][2]);	//this will cause an exception
	}

}
