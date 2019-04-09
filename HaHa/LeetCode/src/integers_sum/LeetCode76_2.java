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
		// ʹ�û�������
		// ����ַ������ȶ�Ϊ0ʱ ֤��û�н� ����""
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}
		String result = s;
		int max = -1;
		Map<Character, Integer> mapT = new HashMap<>();
		Map<Character, Integer> mapS = new HashMap<>();
		// �� t���뵽map�� key = t���ַ� valueΪt���ַ��ĸ���
		for (int i = 0; i < t.length(); i++) {
			int count = mapT.getOrDefault(t.charAt(i), 0);
			mapT.put(t.charAt(i), count + 1);
		}
		int required = mapT.size();
		int formed = 0;
		int l = 0, r = 0;
		// r ָ�������ƶ�
		while (r < s.length()) {
			// ���T�а���s �� r λ�õ��ַ� ���ַ����뵽 mapT�� key = s���ַ� valueΪs���ַ��ĸ���
			char c = s.charAt(r);
			int count = mapS.getOrDefault(c, 0);
			mapS.put(c, count + 1);
			if (mapT.containsKey(c) && mapS.get(c).intValue() == mapT.get(c).intValue()) {
				formed++;
			}
			// ��� mapS �к����� mapT�����е��ַ� (�����Ǹ��� ��l��ʼ�����ƶ�)
			while (l <= r && formed == required) {
				c = s.charAt(l);
				// max = -1 ʱ ��ʾ��ʱ��δ�洢�����������Ӵ������е�һ�δ洢
				// max > (r - l + 1) ʱ��ʾɨ�赽���Ӵ�����С��֮ǰ�洢���Ӵ����򸲸�
				if (max == -1 || max > (r - l + 1)) {
					result = s.substring(l, r + 1);
					max = result.length();
				}
				// l �����ƶ�
				mapS.put(c, mapS.get(c) - 1);
				// �ж������Ƿ�����
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
