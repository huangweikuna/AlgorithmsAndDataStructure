package map_and_set;

import java.util.HashSet;
import java.util.Set;

//����һ�����������һ������k���ҳ��������Ƿ���������ͬ������i��j��
//ʹ��nums[i]��nums[j]֮��ľ��Բ�����Ϊt��i��j֮��ľ��Բ�����Ϊk�� j - i <= k
public class V_LeetCode219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])) //�滻�� nums[i]��nums[j]֮��ľ��Բ�����Ϊt����
				return true;
			set.add(nums[i]);
			if(set.size() == k +1) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}
