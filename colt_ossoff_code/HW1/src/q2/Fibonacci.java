package q2;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fib(25);
	}

	static void fib(int steps) {
		int base1 = 0;
		int base2 = 1;
		int n;
		for(;steps>0;steps--) {
			n = base1 + base2;
			base2 = base1;
			base1 = n;
			System.out.println(n);
		}
	}
}
