package medium;

public class LeetCode33 {
	// ��ѯ��ת�������Ƿ����ĳ����
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid])
				return mid;
			// 6 7 0 1 2 3 4 5
			// ����ȡ��Χ����˼�� [nums[left] < target < nums[mid]]
			if (nums[left] > nums[mid]) {
				if (nums[mid] > target || target >= nums[left])
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				// 2 3 4 5 6 7 0 1
				// ����ȡ��Χ����˼�� [nums[mid] < target < nums[left]]
				if (nums[mid] < target || target < nums[left])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1,3 };
		int res = new LeetCode33().search(arr, 3);
		System.out.println(res);
	}
}
