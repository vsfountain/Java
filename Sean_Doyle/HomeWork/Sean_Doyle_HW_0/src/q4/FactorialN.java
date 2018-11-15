package q4;

public class FactorialN {
	/*
	 * This is the backward recursive implementation of the factorial method
	 * n! = n*(n-1)*(n-2)*...*3*2*1
	 * where the stack produces the result: n! = 1*2*3*...*(n-2)*(n-1)*n
	 */
	public static int Fact(int n) {
		if (n > 1) {
			return n*Fact(n-=1);
		}
		else {
			return 1;
		}
	}
	public static void main(String[] args) {
		int n = 6;//6! is a commonly used value equating to 720
		System.out.println(Fact(n));
	}
}
