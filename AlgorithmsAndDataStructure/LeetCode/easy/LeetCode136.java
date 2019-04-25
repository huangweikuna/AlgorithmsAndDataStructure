package easy;

public class LeetCode136 {
	// nums 数组中每个元素出现二次 除了一个数出现了一次 找出这个数

	//两个数 异或之后会恢复为原来的数
	public int singleNumber(int[] nums) {
		for(int i = 1; i < nums.length; i ++) {
			nums[0] ^= nums[i];  
		}
		return nums[0];
	}

	public static void main(String[] args) {
		int nums[] = { 1,0,1 };
		int res = new LeetCode136().singleNumber(nums);
		System.out.println(res);
	}
}
