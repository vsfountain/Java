package q1;

public class BubbleSort {
	public static void main(String[] args) {
		int[] me = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		
		System.out.print("This is the unsorted list: ");
		for (int idk : me) {
			System.out.print(idk + " ");
		}
		
		
		me = bubbleSort(me);
		
		
		System.out.print("\nThis is the sorted list: ");
		for (int idk : me) {
			System.out.print(idk + " ");
		}
	}
	/*
	 * Bubble sort is a method of sorting an "unordered" list by comparing adjacent slots 
	 * of the list and switching their values if the applied compareTo dictates. This is the 
	 * most inefficient sorting method (unless we introduce optimization) since we have to 
	 * walk through each time moving items up to the spot we left off at minus 1, because 
	 * each pass ensures that a new biggest value rises to the next lowest spot.
	 * O(n^2) time complexity
	 */
	public static int[] bubbleSort(int[] me) {
		for (int j = 0; j < me.length - 1; j++) {
			for (int i = j; i < me.length - 1; i++) {
				if (me[i] > me[i + 1]) {
					int temp = me[i + 1];
					me[i + 1] = me[i];
					me[i] = temp;
				}
			}
		}
		return me;
	}
}
