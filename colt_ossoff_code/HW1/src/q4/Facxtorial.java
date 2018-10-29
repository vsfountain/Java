package q4;

public class Facxtorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fac(8));
	}

	static int fac(int n) {
		int ans = 1;
		for(int i = 1;n>0;n--,i++) {
			ans = ans * i;
		}
		return ans;
	}
}