package tencent50;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1 || strs[0].length() == 0)
			return strs[0];
		String temp = strs[0];
		String res = "";
		int count = 0;
		for (int i = 1; i < strs.length; i++) {
			//保证最短字符串的推出循环
			if (strs[i].length() == count || 
				temp.length() == count || 
				strs[i].charAt(count) != temp.charAt(count))
				return res;
			if (i + 1 == strs.length) {
				res += strs[i].charAt(count);
				count++;
				//因为最后i会加一 所以设置为0 跳过第一位
				i = 0;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String strs[] = { "flower", "flow", "flight" };
//		String strs2[] = { "aa", "aa" };
		String res = new LongestCommonPrefix().longestCommonPrefix(strs);
		System.out.println(res);
	}
}
