package map_and_set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II 找出两个int数组的交集 可以重复 Given two arrays, write
 * a function to compute their intersection. Each element in the result should
 * appear as many times as it shows in both arrays. The result can be in any
 * order.
 */
public class LeetCode350 {
	public int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[Math.min(nums1.length, nums2.length)];
		for (int i = 0; i < nums1.length; i++) {
			int count = map.getOrDefault(nums1[i], 0);
			map.put(nums1[i], count + 1);
		}
		int j = 0;
		for (int i = 0; i < nums2.length; i++) {
			if (map.get(nums2[i]) != null && map.get(nums2[i]) > 0) {
				map.put(nums2[i], map.get(nums2[i]) - 1);
				result[j++] = nums2[i];
			}
		}   

		return Arrays.copyOfRange(result, 0, j);
	}

	public static void main(String[] args) {
		LeetCode350 test = new LeetCode350();
		int[] nums1 = { 4 , 9 , 5 };
		int[] nums2 = { 9,4,9,8,4};
		int[] result = test.intersection(nums1, nums2);
		for (int i = 0; i < result.length; i++)
		System.out.println(result[i]);
	}
}
