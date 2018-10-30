package q10;

public class MinTert {
	public static void main(String[] args) {
		int n1 = 133;
		int n2 = 54;
		System.out.println(n1 + " is greater than "+  n2 +": " + checkMag(n1, n2));
	}
	public static boolean checkMag(int n1, int n2) {
		//boolean expression ? if true : if false
		//Ternary expression
		return n1> n2 ? true:false;
	}
}
