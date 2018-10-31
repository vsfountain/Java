package com.question.q02;

import java.util.ArrayList;

public class Fibonacci {
	
	public Fibonacci(int num) {
		for(int i = 1; i <= num; i++) {
			System.out.print (Fib(i) + " ");
		}
	}
	
	public int Fib(int num) {
		if(num == 1 || num == 2) {
			return 1;
		} else {
			System.out.println(Fib(num));
			return Fib(num - 1) + Fib (num - 2);
		}
	}

}
