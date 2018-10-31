package com.Q2;

public class FibSeq {
	static int F(int N){
		if (N==0) {
			return N;
		}
		if (N == 1) {
			return N;
		}
		int a = F(N-1);
		int b = F(N-2);
		N = a + b;
		return N;
	}
	
	
	public static void main(String[] args) {
		//{F_{n}=F_{n-1}+F_{n-2},}
		int N = 25;
		System.out.println(F(N));
	}
}
