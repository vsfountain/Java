package com.Q12;

import java.util.ArrayList;

public class EnhancedFor {
	

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i<=100; i++) {
			arr.add(i);
		}
		for(Integer even:arr) {
			if (even == 2*(even/2))
			System.out.println(even);
		}
		
	}

}
