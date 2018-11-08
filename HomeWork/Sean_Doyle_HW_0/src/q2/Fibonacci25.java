package q2;

public class Fibonacci25 {
	/*
	 * This is the forward recursive implementation of the fibonacci sequence
	 * F(n) = F(n-1) + F(n-2)
	 */
	public static int Fib(int nm1, int nm2, int n) {
		System.out.println(nm1+nm2);
		if (nm1 >= 0 && nm2 >= 0 && n > 0) {
			return Fib(nm1+nm2, nm1, --n);
		}
		else {
			return nm1+nm2;
		}
	}
	public static void main(String[] args) {
		System.out.println(0 + "\n" + 1);//To satisfy the HW problem, truthfully these are the basecase values
		Fib(1,0,25);
		System.out.println("Woot we have the first 25 Fibonacci numbers!");
	}
}
