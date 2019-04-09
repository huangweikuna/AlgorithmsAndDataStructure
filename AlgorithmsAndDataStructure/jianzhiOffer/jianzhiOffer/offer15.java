package jianzhiOffer;

import java.util.ArrayList;
import java.util.HashMap;

/*
		����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * 
 */
public class offer15 {
	ArrayList<String> list = new ArrayList<>();
	HashMap<Character, Integer> map = new HashMap<>();

	public ArrayList<String> Permutation(String str) {
		if (str.length() <= 0)
			return list;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);
		}
		getPermutation(str, 0, "");
		return list;
	}

	private void getPermutation(String str, int index, String res) {
		if (index == str.length()) {
			if(!list.contains(res))
				list.add(res);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.get(c) != 0) {
				res += c + "";
				map.put(c, map.get(c) - 1);
				getPermutation(str, index + 1, res);
				res = res.substring(0, res.length() - 1);
				map.put(c, map.get(c) + 1);
			}
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		ArrayList<String> list = new offer15().Permutation(s);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}