package integers_move;
/**
 * 
 * @author Administrator Given a sorted array nums, remove the duplicates
 *         in-place such that duplicates appeared at most twice and return the
 *         new length. Do not allocate extra space for another array, you must
 *         do this by modifying the input array in-place with O(1) extra memory.
 */
//消除数组中的重复元素
//重复元素允许出现两次  本题如同26题  只是重复的元素可以出现两次  所以下面设置一个flag标识元素出现的次数
public class LeetCode80 {
	public int removeDuplicates(int[] nums) {
		int flag = 0;
		if (nums.length == 0)
			return 0;
		int i = 0;
		// 两个指针i,j分别重起点开始 j先走如果没有重复 则替换i+1个 (本题容重复个数为2) 设置flag标识重复数字的个数 如果遇到不同的数字则重置
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
				flag = 0;
			} else {
				if (++flag < 2) {
					i++;
					nums[i] = nums[j];
					continue;
				}

			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 2 };
		LeetCode80 test = new LeetCode80();
		System.out.println(test.removeDuplicates(nums));
	}
}
