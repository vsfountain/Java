package com.javahomework.questions13;

public class Triangle {
//i have not figured out how to get this one to work
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = i; j >= 0; j--) {
				System.out.println(j);
				if(counter == 0)
				System.out.println(0);
				else System.out.println(1);
			}
		System.out.println(i);
		i += 1;
		
		}

	}

}