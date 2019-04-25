package easy;

public class LeetCode771 {
	//统计S中含有z的字符的数目  j中的字母保证是不同的，j和s中的所有字符都是字母。字母是区分大小写的
	public int numJewelsInStones(String J, String S) {
		if(J.length() <= 0 || S.length() <= 0)
			return 0;
		int arr[] = new int[256];
		int count = 0;
		for(int i = 0; i < J.length(); i ++) {
			arr[S.charAt(i)]++;
		}
		for(int i = 0; i < S.length(); i ++) {
			if(arr[J.charAt(i)] > 0)
				count ++;
		}
		return count;
	}
}
