package medium;

public class LeetCode64_Minimum_Path_Sum {
	int m, n;
	int res = Integer.MAX_VALUE;
	int [][]memo;
	public int minPathSum(int[][] grid) {
		m = grid.length;
		if (m == 0)
			return 0;
		n = grid[0].length;
		memo = new int[m][n];
		return move(grid, 0, 0);
	}

	private int move(int[][] grid, int x, int y) {
		if (x == m - 1 && y == n - 1) {
			return grid[x][y];
		}
		if(memo[x][y] != 0)return memo[x][y];
		int r = Integer.MAX_VALUE,d = Integer.MAX_VALUE;
		if(x < m - 1)
			r = move(grid, x + 1, y);
		if(y < n - 1)
			d = move(grid, x, y + 1);
		memo[x][y] = Math.min(r, d) + grid[x][y];
		return memo[x][y];
	}
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		int a = new LeetCode64_Minimum_Path_Sum().minPathSum(grid);
		System.out.println(a);
	}
}
/*
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7 Explanation: Because the path
 * 1¡ú3¡ú1¡ú1¡ú1 minimizes the sum.
 */