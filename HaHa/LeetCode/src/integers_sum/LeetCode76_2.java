package integers_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*  
 *     76. Minimum Window Substring
 *     Given a string S and a string T, find the minimum window in S
 *     which will contain all the characters in T in complexity O(n).
 *     Example:
		Input: S = "ADOBECODEBANC", T = "ABC"
		Output: "BANC"
 */
public class LeetCode76_2 {
	public String minWindow(String s, String t) {
		// 使用滑动窗口
		// 如果字符串长度都为0时 证明没有解 返回""
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}
		String result = s;
		int max = -1;
		Map<Character, Integer> mapT = new HashMap<>();
		Map<Character, Integer> mapS = new HashMap<>();
		// 将 t存入到map中 key = t的字符 value为t中字符的个数
		for (int i = 0; i < t.length(); i++) {
			int count = mapT.getOrDefault(t.charAt(i), 0);
			mapT.put(t.charAt(i), count + 1);
		}
		int required = mapT.size();
		int formed = 0;
		int l = 0, r = 0;
		// r 指针向右移动
		while (r < s.length()) {
			// 如果T中包含s 中 r 位置的字符 则将字符加入到 mapT中 key = s的字符 value为s中字符的个数
			char c = s.charAt(r);
			int count = mapS.getOrDefault(c, 0);
			mapS.put(c, count + 1);
			if (mapT.containsKey(c) && mapS.get(c).intValue() == mapT.get(c).intValue()) {
				formed++;
			}
			// 如果 mapS 中含有了 mapT中所有的字符 (不考虑个数 则l开始向右移动)
			while (l <= r && formed == required) {
				c = s.charAt(l);
				// max = -1 时 表示此时还未存储满足条件的子串，进行第一次存储
				// max > (r - l + 1) 时表示扫描到的子串长度小于之前存储的子串，则覆盖
				if (max == -1 || max > (r - l + 1)) {
					result = s.substring(l, r + 1);
					max = result.length();
				}
				// l 向右移动
				mapS.put(c, mapS.get(c) - 1);
				// 判断数量是否还满足
				if (mapT.containsKey(c) && mapS.get(c).intValue() < mapT.get(c).intValue()) {
					formed--;
				}
				l++;

			}
			r++;
		}
		if (max == -1)

		{
			return "";
		}
		return result;
	}

	public static void main(String[] args) {
		LeetCode76_2 test = new LeetCode76_2();
		String s = "AA";
		System.out.println(test.minWindow(s, "AA"));
	}
}
