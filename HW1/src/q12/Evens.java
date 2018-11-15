package q12;

public class Evens {

	public static void main(String[] args) {
		int[] toTest = new int[100];
		
		for ( int x  = 0; x < toTest.length; x++) {
			toTest[x] = x + 1;
		}
		
		for (int x : toTest) {
			if (x%2 == 0) {
				System.out.println(x);
			}
		}

	}

}
