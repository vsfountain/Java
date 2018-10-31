package com.question.q01;

public class BubbleSort {
	
	public BubbleSort(int[] array) {
		while(isNotSorted(array)) {
			sortArray(array);
		}
		printArray(array);
	}

	public boolean needToSort(int firstNum, int secondNum) {
		//System.out.println(firstNum + " >" + " " + secondNum + (firstNum > secondNum));
		if (firstNum > secondNum) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNotSorted(int[] array) {
		for (int i = 0; i < (array.length - 1); i++) {
			if (needToSort(array[i], array[i + 1])) {
				return true;
			}
		}
		return false;
	}

	public void sortArray(int[] array) {
		for (int i = 0; i < (array.length - 1); i++) {
			// System.out.println("array[i] is " + array[i]);
			if (needToSort(array[i], array[i + 1])) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}

		}
	}

	public void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
	}

}
