package integers_sum;

/*  
 *  3. Longest Substring Without Repeating Characters
	Given a string, find the length of the longest substring without repeating characters.
	Input: "abcabcbb"
	Output: 3 
	Explanation: The answer is "abc", with the length of 3. 
 */
//查找不重复的最长子串长度
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
			//记录如果是第一次出现的字符  则存入freq  r 向右移动
			if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
				freq[s.charAt(++r)]++;
			} else {
				//如果不是第一次出现  则l向右移动 并删除掉l位置的元素
				freq[s.charAt(l++)]--;
			}
			//每次更新最大值   这里每次更新的最大值都是 小于等于 没有重复的子串长度
			if (maxLength < r - l + 1)
				maxLength = r - l + 1;
		}
		//说明没有子串 
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
