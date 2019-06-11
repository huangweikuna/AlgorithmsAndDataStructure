package easy;

public class LeetCode581_Shortest_Unsorted_Continuous_Subarray {
	public int findUnsortedSubarray(int[] nums) {
		int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
		
		for(int i = 1; i < nums.length; i ++)
			if(nums[i] < nums[i - 1])
				min = Math.min(min, nums[i]);
		for(int i = nums.length - 2; i >= 0; i --)
			if(nums[i] > nums[i + 1])
				max = Math.max(max, nums[i]);
		
		int l,r;
		for(l = 0;l < nums.length; l ++)
			if(min < nums[l])
				break;
		for(r = nums.length - 1;r >= 0;r --)
			if(max > nums[r])
				break;
		return r - l < 0 ? 0 : r - l + 1;
		
	}
	public static void main(String[] args) {
		int nums[] = {2,3,3,2,4};
		int res = new LeetCode581_Shortest_Unsorted_Continuous_Subarray().findUnsortedSubarray(nums);
		System.out.println(res);
	}
}
