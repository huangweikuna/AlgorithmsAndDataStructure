package medium;

import java.util.Arrays;

public class LeetCode62_Unique_Paths {
	boolean visited[][];
	static int memo[][];

	public int uniquePaths(int m, int n) {
		if (m == 0)
			return 0;
		visited = new boolean[m][n];
		memo = new int[m][n];
		return move(m, n, 0, 0);
	}

	private int move(int m, int n, int x, int y) {
		if (x == m - 1 && y == n - 1) {
			return 1;
		}
		if(memo[x][y] != 0)return memo[x][y];
		int r = 0, d = 0;
		if (x < m - 1)
			r = move(m, n, x + 1, y);
		if (y < n - 1)
			d = move(m, n, x, y + 1);
		memo[x][y] = r + d;
		return memo[x][y];
	}

	public static void main(String[] args) {
		int res = new LeetCode62_Unique_Paths().uniquePaths(3, 7);
		for(int []a : memo) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(res);
	}
}
/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 */