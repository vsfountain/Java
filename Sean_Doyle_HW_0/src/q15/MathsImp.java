package q15;
/*
 * generate a class that implements the method signatures for each of the 4 basic math operations
 * that are in the interface
 */
public class MathsImp implements Maths  {
	public double addition(double a, double b) {
		return a + b;
	}

	public double subtraction(double a, double b) {
		return a - b;
	}

	public double division(double a, double b) {
		if (b == 0) {
			return 0.0;
		}
		return a / b;
	}

	public double multiplication(double a, double b) {
		return a * b;
	}

}
