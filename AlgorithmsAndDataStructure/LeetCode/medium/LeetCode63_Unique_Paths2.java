package medium;

import java.util.Arrays;

public class LeetCode63_Unique_Paths2 {
	int m, n;
	public int uniquePathsWithObstacles(int[][] arr) {
		m = arr.length;
		if (m == 0)
			return 0;
		n = arr[0].length;
		for(int i = 0; i < m; i ++) {
			for(int j = 0; j < n; j ++) {
				if(arr[i][j] == 1)arr[i][j] = 0;
				else {
					if(i == 0 && j == 0)arr[i][j] = 1;
					else if(i == 0 && j != 0)arr[i][j] = arr[i][j - 1];
					else if(i != 0 && j == 0)arr[i][j] = arr[i - 1][j];
					else arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
				}
			}
		}
		return arr[m - 1][n - 1];
	}


	public static void main(String[] args) {
		int arr[][] = {
		                {0,0,0},
		                {0,1,0},
		                {0,0,0}
		              };
		int res = new LeetCode63_Unique_Paths2().uniquePathsWithObstacles(arr);
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