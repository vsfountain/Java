package q04;

public class Factorial {
	public static void main(String[] args) {
		long n = 20; // the factorial you want. max value is 20
		long ans = 1;
		for (long i = n; i >= 1; i--) {
			ans = ans * i;
		}
		// System.out.println(Long.MAX_VALUE);
		System.out.println(ans);
	}

}
