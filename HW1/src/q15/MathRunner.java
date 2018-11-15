package q15;

public class MathRunner implements Mathmatics {
	
	public static void main(String[] args) {
		MathRunner math = new MathRunner();
		System.out.println(math.addition(1,1));
		System.out.println(math.subtraction(1, 1));
		System.out.println(math.multiplication(2, 50));
		System.out.println(math.division(4, 2));
	}

	@Override
	public int addition(int a, int b) {
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a * b;
	}

	@Override
	public int division(int a, int b) {
		return a/b;
	}

}
