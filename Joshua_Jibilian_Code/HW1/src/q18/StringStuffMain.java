package q18;

public class StringStuffMain {

	public static void main(String[] args) {
		StringStuff implemented = new StringStuffImplamented();
		System.out.println(implemented.hasUpper("This has upper"));
		System.out.println(implemented.hasUpper("this has no upper"));
		System.out.println(implemented.toUpper("This has upper"));
		System.out.println(implemented.toInteger("11"));
	}

}
