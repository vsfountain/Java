package com.homework.nine;

import java.util.ArrayList;
import java.util.List;

public class Prime {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			nums.add(i);
		}

		int cnt = 0;
		for (int i = 0; i < nums.size(); i++) {
			// System.out.println("i: " + i);
			if (nums.get(i) % 2 == 0) {
				continue;
			}
			for (int j = 3; j * j <= i; j += 2) {
				// System.out.println("j: " + j);
				if (nums.get(i) > 3) {
					if (nums.get(i) % j == 0) {
						cnt++;
					}
				}
			}
			if (cnt == 0) {
				System.out.println(nums.get(i));
			}

			cnt = 0;
		}

	}

}
