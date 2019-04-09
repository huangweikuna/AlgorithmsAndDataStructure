package integers_sum;

import java.util.ArrayList;
import java.util.List;

/*  
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
 */

//比如给你一个字符串 s  p = "abc"   查找在s中所有的 p的变位词的初始索引  如 abc acb bac bca cab cba 
public class LeetCode438 {
	public List<Integer> findAnagrams(String s, String p) {
		// 使用滑动窗口
		List<Integer> res = new ArrayList<>();
		//s的长度一定要比p来的大
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
        	//确保字符数量匹配
			freqS[s.charAt(++r) - 'a']++;
			//确保添加进来的字符数量是合p 中的这个字符数量是相等的
			//如果不相等  我们移动l  知道把这个字符移除到相等为止
			while (freqS[s.charAt(r) - 'a'] > freqP[s.charAt(r) - 'a']) {
                freqS[s.charAt(l++) - 'a']--;
            }
            //下面的代码确保字符长度匹配
			//意思是 如果r - l + 1 也就是r 和 l 之间的字符数等于我们p的长度    而且我们每个字符的数量都是和p中的数量相同  那么我们就可以得到一个解
			if (r - l + 1 == p.length()) {
                res.add(l);
            }
		}
        return res;
	}

	public static void main(String[] args) {
		LeetCode438 test = new LeetCode438();
		String s = "cbaebabacd";
		System.out.println(test.findAnagrams(s, "abc"));
	}
}
