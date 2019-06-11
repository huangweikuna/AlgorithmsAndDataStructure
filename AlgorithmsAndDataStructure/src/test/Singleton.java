package test;

public class Singleton {
	private Singleton() {
	}

	private volatile static Singleton uniqueInstance;

	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton.class) {
				if (uniqueInstance == null)
					uniqueInstance = new Singleton();
			}
		}
		return uniqueInstance;
	}
	public static void main(String[] args) {
		System.out.println("s");
	}
}
