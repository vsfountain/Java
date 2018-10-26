package com.homework.problemfourteen;
import java.lang.Math;
import java.util.*;

public class SeperateString {

	public static void main(String[] args) {
		int num = 3;
		
		switch(num) {
		case 1:
			System.out.println(Math.sqrt(9));
		case 2:
			System.out.println(new Date().toString());
		case 3:
			String statement = "I am learning Core Java";
			String[] strArry = new String[5];
			int idx = 0;
			int j=0;
			for(int i = 0; i<statement.length();i++) {
				if (statement.charAt(i) == ' ' || i==statement.length()-1){
						strArry[idx] = statement.substring(j,i+1);
						j=i+1;
						idx++;
				}
				
				
			}
			for(String k: strArry) {
				System.out.println(k);
			}
			
		}
	}

}
