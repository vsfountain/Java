package com.revature.day4.threads;

public class RunnableClass implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
}
