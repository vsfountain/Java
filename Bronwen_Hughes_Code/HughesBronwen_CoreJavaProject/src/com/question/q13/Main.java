package com.question.q13;

public class Main {
	
	static int[] array = {0,1,0,1,0,1,0,1,0,1};
	static int x = 0;
	public static void main(String[] args) {
		for(int i = 1; i <= 4; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(array[x]);
				x++;
				//System.out.println("j + 1 = : " + j + " + " + i + " = " + (j+i));
			}
			System.out.println();
		}
	}
	
	
	
}
