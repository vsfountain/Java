package com.hack;

import java.util.Arrays;

public class main{
	
	public static void main(String [] args) {
		int[] grades = {73,67,38,33};
		        /*
		         * Write your code here.
		         */
		
		double joke = 99;
		int closest= (int) Math.ceil(joke/10);
		System.out.println(closest);

		         gradess(grades);
		         for(int i  : grades) {
		        	 System.out.println(i);
		         }
	}

	public static int [] gradess(int [] grades) {
    for(int i =0 ; i < grades.length; i++){
        if(grades[i] < 38) {
        	grades[i]=0;
        	}
        if(grades[i] > 38){
        	int close = grades[i]%5;
            
        }
     }

    return grades;

}
}
	
