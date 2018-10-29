package q18;

public class Concrete extends AbstractClass {

	@Override
	public boolean hasUppers(String str) {
		// TODO Auto-generated method stub
		for(int i = 0; i<str.length(); i++)
			if('A' <= str.charAt(i) || str.charAt(i) <= 'Z')
				return true;
		return false;
	}

	@Override
	public String toUpper(String str) {
		// TODO Auto-generated method stub
		/*char[] result = new char[str.length()];
		for(int i = 0; i < str.length(); i++)
			if(str.charAt(i)>96)
				result[i] = (char) (str.charAt(i) - 32);*/
		return str.toUpperCase();
	}

	@Override
	public void toInt(String n) {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt(n) + 10);
	}

	
}
