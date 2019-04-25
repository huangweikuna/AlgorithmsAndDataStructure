package medium;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode496 {
	// 找到第一个比它大的数
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for(int num : nums2) {
			while(!stack.isEmpty() && num > stack.peek()) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		for(int i = 0; i < nums1.length; i ++) {
			nums1[i] = map.getOrDefault(nums1[i], -1);
		}
		return nums1;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 1, 2 };
		int arr2[] = { 1, 3, 4, 2 };
		int res[] = new LeetCode496().nextGreaterElement(arr, arr2);
		for (int n : res) {
			System.out.println(n);
		}
	}
}
