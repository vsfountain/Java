package q06;

public class DivisibleByTwo {
	public static void main(String[] args) {
		int num = -2; //number to test
		if((num & 1) == 1) {
			System.out.println("Not divisible by two");
		} else {
			System.out.println("Divisible by two");
		}
	}
}
