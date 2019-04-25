package medium;

public class LeetCode49 {
	// �ж�һ���ַ������ж��ٸ������ַ���
	int count = 0;

	public int countSubstrings(String s) {
		for (int i = 0; i < s.length(); i++) {
			// ������չ����
			// ������ĳ���Ϊ����
			exp(s, i, i);
			// �������Ϊż��
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
