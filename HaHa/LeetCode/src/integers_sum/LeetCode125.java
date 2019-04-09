package integers_sum;

/*  
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *	Note: For the purpose of this problem, we define empty string as valid palindrome.
 *			�ж��Ƿ�Ϊ�����ַ���
 */
public class LeetCode125 {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase(); // convert all to lower cases.
		s = s.replaceAll("[^a-z^0-9]+", ""); // remove all non-digital and non-letter.
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

	// 3������С
	public boolean isPalindrome2(String s) {
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String rev = new StringBuffer(actual).reverse().toString();
		return actual.equals(rev);
	}

	public static void main(String[] args) {
		LeetCode125 test = new LeetCode125();
		System.out.println(test.isPalindrome(" "));
	}
}
