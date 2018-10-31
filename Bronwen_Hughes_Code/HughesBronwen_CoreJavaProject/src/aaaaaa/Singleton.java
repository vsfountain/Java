package aaaaaa;

// factory 
// 		- hide sensitive information/args
//		- minimize amount of args to a constructor as needed

public class Singleton {

	private static Singleton Instance;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (Instance == null) {
			Instance = new Singleton();
		}
		return Instance;

	}
}
