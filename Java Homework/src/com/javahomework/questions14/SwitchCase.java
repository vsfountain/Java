package com.javahomework.questions14;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SwitchCase {
	
	public static void main(String[] args) {
		choice(1);
		choice(2);
		choice(3);
		
		
		}
	
	
	static void choice(int n) {
		Scanner in = new Scanner(System.in);
		switch(n) {
		case 1: 
				System.out.print("Enter a number: ");
				int num = in.nextInt();
				System.out.println(Math.sqrt(num));
				break;
		case 2: 
			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   System.out.println(dtf.format(now));  
			   break;
		case 3:
				
				String toBeSplit = new String("I am learning Core Java");
				String [] s = toBeSplit.split(" ");
				
					for(String r : s){
					System.out.println(r);
				}
				
				break;
		default: break;
		}
	}
	
}
