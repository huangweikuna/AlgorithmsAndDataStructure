package easy;

import java.util.ArrayList;
import java.util.List;
public class LeetCode448 {
	//查找数组中没有出现的数字   1-num.length()
	//给每一个值一个负数的状态
	public List<Integer> findDisappearedNumbers(int[] nums) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i ++) {
			int val = Math.abs(nums[i]);
			if(nums[val] > 0) {
				nums[val] = - nums[val];
			}
		}
		for(int i = 0; i < nums.length; i ++) {
			if(nums[i] > 0) {
				list.add(i + 1);
			}
		}
		return list;
	}
}
