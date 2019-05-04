package test;


public class Main {

	public static void main(String[] args) {
		Integer a = -1;
		int count = -1;
		System.out.println("max:"  + Integer.toBinaryString(Integer.MAX_VALUE) + ":  " + Integer.MAX_VALUE);
		System.out.println("-1 :"  + Integer.toBinaryString(-1));
		System.out.println("-2 :" + Integer.toBinaryString(-1));
		System.out.println("-3 :" + Integer.toBinaryString(-3));
		while(count ++ < 32 ) {
			System.out.println(-1 + " <<  " + count + " λ+:  " + Integer.toBinaryString(a) + "  :" + a);
			a = a << 1;
		}
	}
}
