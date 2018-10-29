package com.homework.ninteen;

import java.util.ArrayList;

public class ArrayListsMain {

	public static void main(String[] args) {

		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			nums.add(i);
		}
		System.out.println(nums);
		int cnt = 0;
		for (int j : nums) {
			if (j % 2 == 0) {
				cnt += j;
			}
		}
		System.out.println("The sum of all even numbers 1-10 is " + cnt);

		cnt = 0;
		for (int j : nums) {
			if (j % 2 == 1) {
				cnt += j;
			}
		}
		System.out.println("The sum of all odd numbers 1-10 is " + cnt);

		cnt = 0;
		for (int i = 0; i < nums.size(); i++) {
			if(nums.get(i)<4) {
				nums.remove(i);
				i--;
				continue;
			}
			if (nums.get(i) % 2 == 0) {
				continue;
			}
			for (int j = 3; j * j <= i; j += 2) {
					if (nums.get(i) % j == 0) {
						cnt++;
						break;
				}
			}
			if (cnt == 0) {
				nums.remove(i);
				//i--;
			}

			cnt = 0;
		}

	
		System.out.println("The non-prime numbers 1-10 are " + nums);
	}

}
