package medium;

public class LeetCode34 {
	// 返回目标数的开始和结束
	public int[] searchRange(int[] nums, int target) {
		int res[] = { -1, -1 };
		if (nums.length == 0)
			return res;
		int left = binarySearch(nums, target - 0.5);
		int right = binarySearch(nums, target + 0.5);
		if (right - left == 0)
			return res;
		res[0] = left;
		res[1] = right - 1;
		return res;
	}

	private int binarySearch(int[] arr, double target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] > target)
				right = mid - 1;
			else if(arr[mid] < target)
				left = mid + 1;
		}
		return left;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		int[] res = new LeetCode34().searchRange(nums, 1);
		for (int n : res)
			System.out.println(n);
	}
}
