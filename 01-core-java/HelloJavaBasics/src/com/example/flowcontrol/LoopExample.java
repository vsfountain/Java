package com.example.flowcontrol;

public class LoopExample {

	public static void main(String[] args) {
		//what is a loop?
		
		/*//while loop
		int i= 7;
		while(i<10) {//operators:  &&, ||, <, <=, >, >=, ==, !=
			System.out.println("inside the while loop: "+ i++);
			
		}*/
		
		// do while loop
		/*do{
			System.out.println("do while loop");
		}while(i<1);*/
		
		//for loop
		/*int j=0;
		for(j=0; j<3;j=j+19) {
			System.out.println("inside for loop: "+j++);
		}*/
		
		int[] arryOne= {67,89,100,23,45,67,55};
		/*for(int i=0; i<arryOne.length; i++) {
			System.out.println(arryOne[i]);
		}*/
		
		for(int p: arryOne){ // for each loop....aka enhanced for loop
			System.out.println(p);
		}
		
		System.out.println("done");
	}

}
