package com.bank.main;

import java.util.Scanner;

public class ScannerSingleton {
	private static Scanner scanner;
	
	private ScannerSingleton() {}
	
	public static Scanner instance() {
		if(scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
}
