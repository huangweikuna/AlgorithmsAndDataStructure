package jianzhiOffer;

public class offer2 {
	public String replaceSpace(StringBuffer str) {
		return str.toString().replaceAll(" ", "%20");

	}

	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("We are young");
		System.out.println(new offer2().replaceSpace(s));
	}
}