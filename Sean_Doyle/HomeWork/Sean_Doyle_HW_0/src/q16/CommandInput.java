package q16;

//all we are doing is taking a command line string and printing out its length
//if there is no command line input provided then the program ends
public class CommandInput {
	public static void main(String[] args) {
		if (args != null) {
			System.out.println(args[0].length());
		}
	}
}
