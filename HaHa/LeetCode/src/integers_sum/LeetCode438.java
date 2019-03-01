package integers_sum;

import java.util.ArrayList;
import java.util.List;

/*  
 *  3. Longest Substring Without Repeating Characters
	Given a string, find the length of the longest substring without repeating characters.
	Input: "abcabcbb"
	Output: 3 
	Explanation: The answer is "abc", with the length of 3. 
 */
public class LeetCode438 {
	public List<Integer> findAnagrams(String s, String p) {
		// 使用滑动窗口
		List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
        }
        int l = 0, r = -1;
        while (r + 1 < s.length()) {
			freqS[s.charAt(++r) - 'a']++;
			while (freqS[s.charAt(r) - 'a'] > freqP[s.charAt(r) - 'a']) {
                freqS[s.charAt(l++) - 'a']--;
            }
			//上部分代码确保字符数量匹配
            //下面的代码确保字符长度匹配
			if (r - l + 1 == p.length()) {
                res.add(l);
            }
		}
        return res;
	}

	public static void main(String[] args) {
		LeetCode438 test = new LeetCode438();
		String s = "bbbb";
		System.out.println(test.findAnagrams(s, "bb"));
	}
}
