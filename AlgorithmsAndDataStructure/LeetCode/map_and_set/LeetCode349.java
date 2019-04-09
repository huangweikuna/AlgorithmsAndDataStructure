package map_and_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 *	349. Intersection of Two Arrays 找出两个int数组的交集 不可以重复
 *	Given two arrays, write a function to compute their intersection.
	Example 1:
	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2]
 */
public class LeetCode349 {
	public int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> resultSet = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i])) {
				resultSet.add(nums2[i]);
			}
		}
		int[] result = new int[resultSet.size()];
		Iterator<Integer> it = resultSet.iterator();
		int i = 0;
		while (it.hasNext()) {
			result[i++] = it.next();
		}
		return result;
	}
	public static void main(String[] args) {
		LeetCode349 test = new LeetCode349();
		int[] nums1 = {1,1,2,3};
		int[] nums2 = {1,1,2};
		test.intersection(nums1, nums2);
	}
}
