package integers_sum;

import java.util.HashMap;

/*  
 *     76. Minimum Window Substring
 *     Given a string S and a string T, find the minimum window in S
 *     which will contain all the characters in T in complexity O(n).
 *     Example:
		Input: S = "ADOBECODEBANC", T = "ABC"
		Output: "BANC"
 */
public class LeetCode76 {
	public String minWindow(String s, String t) {
		if(s.length() < t.length())return "";
		HashMap<Character,Integer> mapT = new HashMap<>();
		HashMap<Character,Integer> mapS = new HashMap<>();
		for(int i = 0 ; i < t.length() ; i ++) {
			char c = t.charAt(i);
			int count = mapT.getOrDefault(c, 0);
			mapT.put(c, count + 1);
		}
		int formed = 0;
		int requested = mapT.size();
		int minL = -1;
		int left = 0,right = 0;
		String result = "";
		while(right < s.length()) {
			char c = s.charAt(right);
			int count = mapS.getOrDefault(c, 0);
			mapS.put(c, count + 1);
			if(mapT.containsKey(c) && mapT.get(c).intValue() == mapS.get(c).intValue())
				formed++;
			while(left <= right && formed == requested) {
				if(minL == -1 || minL > right - left + 1) {
					result = s.substring(left, right + 1);
					minL = result.length();
				}
				mapS.put(s.charAt(left),mapS.get(s.charAt(left)) - 1);
				if(mapT.containsKey(s.charAt(left)) && mapT.get(s.charAt(left)).intValue() > mapS.get(s.charAt(left)).intValue()) {
					formed --;
				}
				left ++;
			}
			right++;
		}
		if(minL == -1)
			return "";
		return result;
	}

	public static void main(String[] args) {
		LeetCode76 test = new LeetCode76();
		String s = "aaaaaaaaaaaabbbbbcdd";
		System.out.println(test.minWindow(s, "abcdd"));
	}
}
