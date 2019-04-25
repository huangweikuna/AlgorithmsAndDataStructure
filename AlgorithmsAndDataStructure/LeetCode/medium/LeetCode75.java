package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//给定一个字符串数组，将变位词组合在一起。
public class LeetCode75 {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return new ArrayList<>();
		List<List<String>> listAll = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			String hash = hash(s);
			if (!map.containsKey(hash))
				map.put(hash, new ArrayList<String>());
			map.get(hash).add(s);
		}
		listAll.addAll(map.values());
		return listAll;
	}

	private String hash(String s) {
		int arr[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}
		return Arrays.toString(arr);
	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> list = new LeetCode75().groupAnagrams(strs);
		System.out.println(list.toString());
	}
}
