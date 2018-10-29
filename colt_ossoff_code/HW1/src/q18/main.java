package q18;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Concrete concrete = new Concrete();
		String s = "Hello World";
		boolean hasUppers = concrete.hasUppers(s);
		System.out.println("String has Uppers? " + hasUppers);
		String uppers = concrete.toUpper(s);
		System.out.println(uppers);
		concrete.toInt("90");
		
	}

}
