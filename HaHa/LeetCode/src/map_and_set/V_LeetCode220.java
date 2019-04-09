package map_and_set;

import java.util.TreeSet;

//给定一个整数数组和一个整数k，找出数组中是否有两个不同的索引i和j，
//使得nums[i]和nums[j]之间的绝对差至多为t，i和j之间的绝对差至多为k。 j - i <= k
public class V_LeetCode220 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || k < 0 || t < 0)
			return false;
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i - k - 1 >= 0)
				set.remove((long) nums[i - k - 1]);
			Long v = (long) nums[i];
			if (set.floor(v) != null && v - set.floor(v) <= t || set.ceiling(v) != null && set.ceiling(v) - v <= t) {
				return true;
			}
			set.add(v);
		}
		return false;
	}
}
