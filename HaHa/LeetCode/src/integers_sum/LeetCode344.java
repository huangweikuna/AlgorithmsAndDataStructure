package integers_sum;

/*  
 *  		·­×ª×Ö·û´®
 */
public class LeetCode344 {
	public void reverseString(char[] s) {
		int l = 0, r = s.length - 1;
		while (l <= r) {
			char ch = s[l];
			s[l++] = s[r];
			s[r--] = ch;
		}
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	public static void main(String[] args) {
		LeetCode344 test = new LeetCode344();
		char[] ch = { };
		test.reverseString(ch);
	}
}
