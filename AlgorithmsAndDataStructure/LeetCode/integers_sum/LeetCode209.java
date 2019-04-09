package integers_sum;

/*  
 *  209. Minimum Size Subarray Sum
	Given an array of n positive integers and a positive integer s, find the minimal length
	 of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
	Example: 
	Input: s = 7, nums = [2,3,1,2,4,3]
	Output: 2
	Explanation: the subarray [4,3] has the minimal length under the problem constraint.
	//给你一个数组  要求在数组中找到连续的最小长度的子数组(子数组的和为 sums) 
 */
public class LeetCode209 {
	public int minSubArrayLen(int s, int[] nums) {
		// 使用滑动窗口
		int l = 0, r = -1;
		// 设置还未移动最大的间距
		int minIndex = nums.length + 1;
		int sum = 0;
		while (l <= nums.length - 1) {
			// 说明r还可以继续移动
			if (r + 1 < nums.length && sum < s) {
				r++;
				sum += nums[r];
			} else {
				sum -= nums[l];
				l++;
			}
			//更新最小值
			if (sum >= s) {
				if (minIndex > r - l + 1)
					minIndex = r - l + 1;
			}
		}
		//说明不存在这样的连续子数组
		if(minIndex == nums.length + 1)
			return 0;
		return minIndex;
	}

	public static void main(String[] args) {
		LeetCode209 test = new LeetCode209();
		int[] nums = {};
		System.out.println(test.minSubArrayLen(7, nums));
	}
}
