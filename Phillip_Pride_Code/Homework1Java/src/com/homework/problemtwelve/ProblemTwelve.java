package com.homework.problemtwelve;

public class ProblemTwelve {

	public static void main(String[] args) {
		int[] numArry = new int[100];
		for(int i=0; i<100; i++) {
			numArry[i] = i+1;
		}
		
		for(int j: numArry) {
			if(j%2==0)
				System.out.println(j);
		}

	}

}
