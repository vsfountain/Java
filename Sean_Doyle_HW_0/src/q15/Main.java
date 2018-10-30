package q15;
//show that the methods that are from the interface are implemented and work
public class Main{
	public static void main(String[] args) {
		double a = 10;
		double b = 7;
		MathsImp mimp = new MathsImp();
		System.out.println(a+b + " should be " + mimp.addition(a,b));
		System.out.println(a-b + " should be " + mimp.subtraction(a,b));
		System.out.println(a/b + " should be " + mimp.division(a,b));
		System.out.println(a*b + " should be " + mimp.multiplication(a,b));
	}
}
