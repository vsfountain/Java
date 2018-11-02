package com.example.multithreading;

public class MyFirstThread {

	public static void main(String[] args) throws InterruptedException {

		//How do we create a thread in java?
		//	Thread thread= new Thread();
		
		//This is how we grab the reference to the current thread we're in
		Thread mainThread = Thread.currentThread();
		
		boolean isDaemon = mainThread.isDaemon();
		System.out.println(isDaemon);
		
		mainThread.sleep(2000);
		
		String name= mainThread.getName();
		System.out.println("Thread's name: "+name);
	}

}
