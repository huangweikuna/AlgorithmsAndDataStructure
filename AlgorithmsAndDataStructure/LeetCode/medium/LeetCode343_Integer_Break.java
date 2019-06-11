package medium;

public class LeetCode343_Integer_Break {
	int []memo;
	public int integerBreak(int n) {
		memo = new int[n + 1];
		return breakInteger(n);
	}
	private int breakInteger(int n) {
		if(n == 1)return 1;
		if(memo[n] != 0)return memo[n];
		
		int res = -1;
		for(int i = 1; i <= n - 1; i ++) {
			res = Math.max(res,Math.max(i * (n - i), i * breakInteger(n - i)));
		}
		memo[n] = res;
		return res;
	}
	//动态规划解法！
	public int integerBreak2(int n) {
		memo = new int[n + 1];
		memo[1] = 1;
		for(int i = 2; i <= n; i ++)
			for(int j = 1; j < i; j ++)
				memo[i] = Math.max(memo[i],Math.max(j * (i - j), j * memo[i - j]));
		return memo[n];
	}
	private int a() {
		return 1;
	}
	
	public static void main(String[] args) {
		int res = new LeetCode343_Integer_Break().integerBreak2(5);
		System.out.println(res);
		System.out.println(32 & 31);
	}
}
/*Share
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
Note: You may assume that n is not less than 2 and not larger than 58.*/