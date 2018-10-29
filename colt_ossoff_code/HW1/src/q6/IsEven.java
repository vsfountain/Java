package q6;

public class IsEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isEven(9));
		System.out.println(isEven(8));
	}

	static String isEven(int num) {
		int pe = num/2;
		int po = (num+1)/2;
		if (po != pe) return "odd";
		else return "even";
	}
}
