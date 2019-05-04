package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {
	// 有重复数字的数组组合
	List<List<Integer>> allList = new ArrayList<>();
	boolean used[];

	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length == 0)
			return new ArrayList<>();
		used = new boolean[nums.length];
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		helper(list, 0, nums);
		return allList;
	}

	private void helper(List<Integer> list, int index, int[] nums) {
		if (index == nums.length) {
			allList.add(new ArrayList<>(list));
			//System.out.println("all add" + list.toString());
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || ( i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) ) 
				continue;
			used[i] = true;
			//System.out.println("list add" + nums[i]);
			list.add(nums[i]);
			helper(list, index + 1, nums);
			list.remove(list.size() - 1);
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 3 };
		List<List<Integer>> res = new LeetCode47().permuteUnique(arr);
		System.out.println(res.toString());
 	}
}
