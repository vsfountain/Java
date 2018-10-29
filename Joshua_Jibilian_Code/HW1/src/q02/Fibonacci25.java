package q02;

public class Fibonacci25 {
	public static void main(String[] args) {
		int fibN_2 = 0;
		int fibN_1 = 1;
		int fibTemp;
		System.out.print("0, 1, ");
		for(int y = 0; y<23; y++) {
			fibTemp = fibN_2 + fibN_1;
			fibN_2 = fibN_1;
			fibN_1 = fibTemp;
			System.out.print(fibTemp + ", ");
		}
	}
}
