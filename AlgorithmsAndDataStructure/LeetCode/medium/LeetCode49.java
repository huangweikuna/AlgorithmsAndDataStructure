package medium;

public class LeetCode49 {
	// 判断一个字符串中有多少个回文字符串
	int count = 0;

	public int countSubstrings(String s) {
		for (int i = 0; i < s.length(); i++) {
			// 中心扩展查找
			// 如果回文长度为奇数
			exp(s, i, i);
			// 如果回文为偶数
			exp(s, i, i + 1);
		}
		return count;
	}

	private void exp(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
	}

	public static void main(String[] args) {
		String s = "aaa";
		int res = new LeetCode49().countSubstrings(s);
		System.out.println(res);
	}
}
