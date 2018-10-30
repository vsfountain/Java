package com.storenumbers.array;
/**
 * Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even
* numbers from the array. Use the enhanced FOR loop for printing out the numbers.
* 
 * @author Kristen Kavanagh
 * @version 10/29/2018
 *
 */
public class Storenumbers {
	   private int[] numbers;
	   public Storenumbers(int[] numbersIn) {
	      numbers = numbersIn;
	   }
	   public int[] findEvens() {
	     int [] numbers = new int [100];
	      for (int i = 0; i < numbers.length; i++) {
	         if (i % 2 == 0) {
	           
	         }
	      }
	  int[] evens = new int[100];
	  int count = 0;
	  for (int i = 0; i < numbers.length; i++) {
	     if (numbers[i] % 2 == 0) {
	        evens[count] = numbers[i];
	        count++;
	     }      
	  }      
	  return evens;
	}
	   public static void main(String []args) {
		   System.out.println();
		
	}

//public class Storenumbers {
//	
//		   
//	public static void main(String[] args) {
//		// declaring numbers 
//		int numbers [] = new int [100];
//		// get even numbers
//		//print array
//				      for (int i = 0; i < numbers.length; i++) {
//		         if (i % 2 == 0) {
//		        	 
//		        	 
//		           System.out.println();
//		         }
//				      }
////		      }
//		  int[] evens = new int[numbers];
//		  int count = 0;
//		  for (int i = 0; i < numbers.length; i++) {
//		     if (numbers[i] % 2 == 0) {
//		        evens[count] = numbers[i];
//		        count++;
//		     }      
//		  }      
//		  return evens;
//		}
		
//	    for(int i = 0; i < numbers.length; i++) {
//            int currentNumber = numbers[i];
//            if (currentNumber % 2 == 0 || currentNumber % 5 == 0) {
//                    sum = sum + currentNumber;      
//            }       
//    }
//
//	}

}
