package q13;

public class TFTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean tf = false;
		
		for(int i = 0; i <4; i++) {
			for(int j = 0; j<i+1; j++) {
				if(tf == false) System.out.print(0);
				else System.out.print(1);
				tf = !tf;
			}
			System.out.println();
		}
	}

}
