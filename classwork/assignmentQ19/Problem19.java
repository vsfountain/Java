package com.assignmentQ19;

import java.util.ArrayList;
public class Problem19 {
	public static void main(String[] args) {
		manipulateArrayList();
	}
	public static boolean isPrime(int num) {
		if(num < 2) {
			return false;
		}
		for (int i = 2; i< num; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;		
	}
	static void manipulateArrayList() {
		ArrayList <Integer> nums = new ArrayList();
		
		for (int i = 1;i<=10;i++) {
			nums.add(i);
		}
		System.out.println(nums);
		
		int odds= 0;
		for(int idx : nums) {//creates odds total
			if(idx % 2 == 1) {				
				odds += idx;				
			}
		}
		
		int evens= 0;
		for(int idx : nums) {//creates evens total
			if(idx % 2 == 0) {				
				evens += idx;				
			}
		}
		
		System.out.println("Even numbers totaled are " + evens);
		System.out.println("Odd numbers totaled are " + odds);
		
		int count = 0;
		for (int i = 0; i<nums.size();i++) {
			//System.out.print(nums.get(i) + " ");
			if(isPrime(nums.get(i - count))) {
				nums.remove(nums.get(i - count++));				
			}
		}
		System.out.println("Non prime numbers left in ArrayList:" + nums);
	}
}
