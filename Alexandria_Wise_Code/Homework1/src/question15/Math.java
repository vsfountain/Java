package question15;

public class Math implements Operations {

	@Override
	public void add(int x, int y) {	
		int z = x+y;
		System.out.println("x + y = "+z);
	}

	@Override
	public void subtract(int x, int y) {
		int z = x-y;
		System.out.println("x - y = "+z);
		
	}

	@Override
	public void multiply(int x, int y) {
		int z = x*y;
		System.out.println("x * y = "+z);
		
	}

	@Override
	public void divide(int x, int y) {
		int z = x/y;
		System.out.println("x / y = "+z);
	}
	
	

}
