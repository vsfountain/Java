package q01;

public class BubbleSort {

	public static void main(String[] args) {
		int[] toSort = {1,0,5,6,3,2,7,9,8,4};
		int temp = 0;
		
		// x is how many have been sorted
		for (int x = 0; x < toSort.length; x++) { 
			//y is the beginning of two elements to sort.
			for (int y = 0; y < toSort.length - x - 1; y++) { 
				if (toSort[y] > toSort[y+1]) { //if first greater then second, switch
					temp = toSort[y];
					toSort[y] = toSort[y+1];
					toSort[y+1]= temp;
					
				}
				//Debug stuff
				/*for(int thing : toSort) {
					System.out.print(thing + ", " );
				}
				System.out.println("");*/
			}
		}
		for(int x : toSort) {
			System.out.print(x + ", " );
		}

	}

}
