package medium;

import java.util.Arrays;

public class LeetCode279_Perfect_Squares {
	static int []memo;
	public int numSquares(int n) {
		memo = new int[n + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0] = 0;
		for(int i = 1; i <= n; i ++) {
			for(int j = 1; i - j*j >= 0; j ++) {
				memo[i] = Math.min(memo[i],1 + memo[i - j * j]);
			}
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
		int res = new LeetCode279_Perfect_Squares().numSquares(13);
		System.out.println(res);
		System.out.println(Arrays.toString(memo));
	}
}
/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.*/