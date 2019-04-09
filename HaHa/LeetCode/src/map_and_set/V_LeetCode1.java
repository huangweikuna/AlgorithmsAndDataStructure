package map_and_set;

import java.util.HashMap;
import java.util.Map;

//�����������Ƿ����������Ϊtarget��������  �������������±�(��0��ʼ)  ���鲻����
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
