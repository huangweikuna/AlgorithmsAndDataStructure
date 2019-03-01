package map_and_set;

import java.util.HashSet;
import java.util.Set;

//����һ�����������һ������k���ҳ��������Ƿ���������ͬ������i��j��
//ʹnums[i]=nums[j]��i��j֮��ľ��Բ�����Ϊk�� j - i <= k
public class V_LeetCode220 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
			if(set.size() == k +1) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}
