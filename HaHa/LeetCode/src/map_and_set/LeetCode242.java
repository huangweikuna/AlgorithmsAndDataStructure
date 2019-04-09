package map_and_set;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram Given two strings s and t , write a function to determine
 * if t is an anagram of s. Example 1: Input: s = "anagram", t = "nagaram"
 * Output: true
 */
public class LeetCode242 {
	public boolean isAnagram(String s, String t) {
		Map<Character, Integer> mapT = new HashMap<Character, Integer>();
		Map<Character, Integer> mapS = new HashMap<Character, Integer>();
		if(s.length() != t.length())
			return false;
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			int count = mapT.getOrDefault(c, 0);
			mapT.put(c, count + 1);
		}
		int requested = mapT.size();
		int nowLength = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = mapS.getOrDefault(c, 0);
			if(mapT.containsKey(c)) {
				mapS.put(c, count + 1);
				if(mapT.get(c).intValue() == mapS.get(c).intValue())
					nowLength ++;
			} else {
				return false;
			}
				
		}
		if(nowLength == requested)
			return true;
		return false;
	}
	/*
	 //由于两个字符串长度是相同的   所以只要扫描字符数量是否相同就可以了
	 public boolean isAnagram(String s, String t) {
	    if (s == null || t == null || s.length() != t.length()) {
	      return false;
	    }
	    char[] sChars = s.toCharArray();
	    char[] tChars = t.toCharArray();
	
	    int[] sCount = new int[197];
	    int[] tCount = new int[197];
	
	    for (int i = 0; i < tChars.length; i++) {
	      sCount[sChars[i]]++;
	      tCount[tChars[i]]++;
	    }
	    for (int i = 0; i < 197; i++) {
	      if (sCount[i] != tCount[i]) {
	        return false;
	      }
	    }
	    return true;
	 }
	*/
	public static void main(String[] args) {
		LeetCode242 test = new LeetCode242();
		System.out.println(test.isAnagram("aa","a"));
	}
}
