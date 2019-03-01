package integers_sum;

/*  
 *  3. Longest Substring Without Repeating Characters
	Given a string, find the length of the longest substring without repeating characters.
	Input: "abcabcbb"
	Output: 3 
	Explanation: The answer is "abc", with the length of 3. 
 */
public class LeetCode3 {
	public int lengthOfLongestSubstring(String s) {
		// 使用滑动窗口
		int l = 0, r = -1;
		// 设置最大子串长度
		int maxLength = 0;
		int[] freq = new int[256];
		for (int i = 0; i < freq.length; i++) {
			freq[i] = 0;
		}
		while (l <= s.length() - 1) {
			if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
				freq[s.charAt(++r)]++;
			} else {
				freq[s.charAt(l++)]--;
			}
			if (maxLength < r - l + 1)
				maxLength = r - l + 1;
		}
		if (maxLength == 0)
			return 0;
		return maxLength;
	}

	public static void main(String[] args) {
		LeetCode3 test = new LeetCode3();
		String s = "abcabcbb";
		System.out.println(test.lengthOfLongestSubstring(s));
	}
}
