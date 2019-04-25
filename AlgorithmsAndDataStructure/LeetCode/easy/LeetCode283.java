package easy;

public class LeetCode283 {
	// 将数组中的0 移动到末尾 保持其他元素的排列顺序
	public void moveZeroes(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}
		for (; j < nums.length; j++) {
			nums[j] = 0;
		}
	}

	public static void main(String[] args) {
		int nums[] = { 0,1,0,3,12 };
		new LeetCode283().moveZeroes(nums);
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}
}
