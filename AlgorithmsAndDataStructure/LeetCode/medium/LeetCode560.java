package medium;

import java.util.HashMap;

public class LeetCode560 {
	// 最大子串和为k
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int res = 0;
		int sum = 0;
		map.put(0, 1);
		for(int i = 0; i < nums.length;i ++) {
			sum += nums[i];
			if(map.containsKey(sum - k)) {
				res += map.get(sum - k);
			}
			map.put(sum,map.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		int res = new LeetCode560().subarraySum(nums, 2);
		System.out.println(res);
	}
}
