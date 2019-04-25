package medium;

public class LeetCode416 {
	// 看数组是否可以分成两个相同的子集 子集和相等
	public boolean canPartition(int[] nums) {
		if (nums.length < 2)
			return false;
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if(sum % 2 != 0)return false;
		sum /= 2;
		//查找数组中有没有和为sum的子集
		
		
	}
}
