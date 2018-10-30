package question2;

public class FibonacciSeries {
	public static void main(String[] args) {
		int[] Fib = new int[25];
		
		Fib[1] = 1;
		for(int i=2;i<25;i++) {
			Fib[i] = Fib[i-1]+Fib[i-2];
		}
		
		for (int p : Fib) { 			//Print sorted array
			System.out.println(p);
		}
	}

}
