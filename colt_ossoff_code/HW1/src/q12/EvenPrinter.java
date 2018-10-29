package q12;

public class EvenPrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] vals = new int[100];
		for(int i=0; i<vals.length; i++)
			vals[i] = i+1;
		
		for(int val:vals)
			if((val%2) == 0)
				System.out.println(val);
	}

}
