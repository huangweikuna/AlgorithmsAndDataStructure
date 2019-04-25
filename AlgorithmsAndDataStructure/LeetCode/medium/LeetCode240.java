package medium;

public class LeetCode240 {
	//返回二维数组中是否存在某个数 
	//二维数组每一行都是递增序列
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0)return false;
		int row = 0;
		int col = matrix[0].length - 1;
		while(col >= 0 && row < matrix.length) {
			int temp = matrix[row][col];
			if(temp == target)return true;
			else if(temp > target)col --;
			else row ++;
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[][] = { 
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		boolean res = new LeetCode240().searchMatrix(arr, 5);
		System.out.println(res);
	}
}
