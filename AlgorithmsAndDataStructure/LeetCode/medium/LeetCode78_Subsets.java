package medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78_Subsets {
	static List<List<Integer>> res;

	public List<List<Integer>> subsets(int[] nums) {
		res = new ArrayList<>();
		if (nums.length == 0)
			return res;
		subSet(nums, 0, new ArrayList<Integer>());
		return res;
	}

	private void subSet(int[] nums, int index, ArrayList<Integer> list) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			subSet(nums, i + 1, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		new LeetCode78_Subsets().subsets(new int[] { 1, 2, 3 });
		System.out.println(res.toString());
	}

}
