package question1;

public class BubbleSort {
	public static void main(String[] args) {
		
		//variable declarations
		int[] X = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int temp;

		//Nested loops for Bubble Sort
		for (int j = 0; j < X.length; j++) {
			for (int i = 0; i < X.length - 1; i++) {
				if (X[i] > X[i + 1]) {					//Check order of adjacent elements
					temp = X[i];						//Swap elements if not in increasing order
					X[i] = X[i + 1];
					X[i + 1] = temp;
				}

			}
		}
		for (int p : X) { 								//Print sorted array
			System.out.print(p);
		}
	}

}
