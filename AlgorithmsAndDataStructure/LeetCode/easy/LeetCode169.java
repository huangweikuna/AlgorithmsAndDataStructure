package easy;

import java.util.HashMap;

public class LeetCode169 {
	// 查找数组中出现次数大于n/2 取下限 的值
	public int majorityElement(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i ++) {
			int count = map.getOrDefault(nums[i], 0);
			if(count + 1 > nums.length / 2)
				return nums[i];
			map.put(nums[i], count + 1);
		}
		return -1;
	}
	//摩尔投票算法
	public int majorityElement2(int[] nums) {
		int count = 0;
		int res = 0;
		for(int n : nums) {
			if(count == 0) {
				res = n;
				count = 1;
			}
			if(n == res)
				count ++;
			else 
				count --;
		}
		return res;
	}
}
