package q11_1;

import q11_2.SomeClass;

public class PackageAccess {
public static void main(String[] args) {
	SomeClass me = new SomeClass();
	System.out.println("My eyes have luminosity: "+me.eyes);
	System.out.println("My lips have luster: "+me.lips);
}
}
