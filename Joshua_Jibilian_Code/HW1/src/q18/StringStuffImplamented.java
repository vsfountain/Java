package q18;

public class StringStuffImplamented extends StringStuff{

	@Override
	public Boolean hasUpper(String a) {
		for (Character b : a.toCharArray()) {
			if (b >= 65 && b<= 90) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toUpper(String a) {
		return a.toUpperCase();
	}

	@Override
	public int toInteger(String a) {
		return Integer.parseInt(a);
	}

}
