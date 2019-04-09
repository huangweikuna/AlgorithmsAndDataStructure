package map_and_set;

import java.util.HashMap;
import java.util.Map;

//查找数组中是否含有两个相加为target的两个数  返回两个数的下标(重0开始)  数组不排序
public class V_LeetCode1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = { 0, 0 };
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				return result;
			} else 
				map.put(nums[i], i);
		}
		return null;
	}
}
