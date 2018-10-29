package com.homework.question13;

public class TriangleDisplayed {
	public static void main(String[] args) {
		int[] triangleVars = {0, 1, 0, 1};
		int counter = 2;
		int varCount = 2;
		int track = 0;
		while(true) {
			for(int i = counter; i <= varCount; i++) {
				System.out.print(triangleVars[i] + " ");
			}
			if(counter==0) {
				break;
			}
			if(track==0) {
				counter--;
			}
			if(track==1) {
				varCount++;
			}
			if(track==0) {
				track=1;
			}
			else if(track==1) {
				track=0;
			}
			System.out.println();
		}
	}
}
