package medium;

public class LeetCode287 {
	public int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				if (nums[nums[i]] != nums[i])
					swap(nums[i], i, nums);
				else
					return nums[i];
			}
		}
		return -1;
	}

	private void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 3,1,3,4,2 };
		int res = new LeetCode287().findDuplicate(arr);
		System.out.println(res);
	}
}
