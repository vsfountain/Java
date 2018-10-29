package com.assignmentQ14.switchproject;

import java.util.*;
public class SwitchProject {
	
	public static void main(String[] args) {
		testSwitch();
	}	
	
	public static void testSwitch() {
		int test = 1;
		switch(test) {
			case 1: 
				System.out.println(Math.sqrt(16));
				break;
			case 2: 
				System.out.println(new Date());
				break;
			case 3: 
				String s = "I am learning Core Java";
				String[] splitStr =	s.split(" ");
				System.out.println(Arrays.toString(splitStr));
				break;
			default:
				break;
		}
	}
}
