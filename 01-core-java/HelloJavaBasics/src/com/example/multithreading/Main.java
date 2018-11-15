package com.example.multithreading;
/*
 * Pros and cons of extending thread vs implementing runnable:
 * 
 * extending:
 * 		if you WANT to override some functionality
 * 
 * implementing:
 * 		Light weight, you don't have to include unwanted methods.
 * 		YOu can STILL extend another class
 * 
 */
public class Main {

	public static void main(String[] args) {

		//creating and launching a custom thread, by extending thread class
		MyThread myThread= new MyThread();
		myThread.start();
		
		//creating and launching a custom thread, by implement runnable
		MyRunnable myRun= new MyRunnable();
		Thread regularThread= new Thread(myRun);
		
		regularThread.start();
		
		//myThread.run();  //this will NOT create a separate thread
		//	it'll run the run method inside of the current thread
		
		for(int i=0; i<20; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
