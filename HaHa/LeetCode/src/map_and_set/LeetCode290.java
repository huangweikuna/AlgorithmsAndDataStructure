package map_and_set;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * 
 * Given a pattern and a string str, find if str follows the same pattern. Here
 * follow means a full match, such that there is a bijection between a letter in
 * pattern and a non-empty word in str. Example 1: Input: pattern = "abba", str
 * = "dog cat cat dog" Output: true
 */
public class LeetCode290 {
	// 给出一个模板 给的非空单词字符串要符合模板的格式
	// 可以使用hashmap 使每一个模板的字母对应一个单词 进行扫描匹配
	//注意进行双向满足   避免 a = dog   b = dog 
	public boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<Character, String>();
		Map<String, Character> map2 = new HashMap<String, Character>();
		String[] strs = str.split(" ");
		if(strs.length != pattern.length()) 
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			if(map.containsKey(pattern.charAt(i))) {
				if(!map.get(pattern.charAt(i)).equals(strs[i]))
					return false;
			} else 
				map.put(pattern.charAt(i), strs[i]);
			if(map2.containsKey(strs[i])) {
				if(map2.get(strs[i]) != pattern.charAt(i))
					return false;
			} else 
				map2.put(strs[i],pattern.charAt(i));
		}
		return true;
	}
	public static void main(String[] args) {
		LeetCode290 test = new LeetCode290();
		String pattern = "abba";
		String str = "dog dog dog dog";
		System.out.println(test.wordPattern(pattern, str));
	}
}
