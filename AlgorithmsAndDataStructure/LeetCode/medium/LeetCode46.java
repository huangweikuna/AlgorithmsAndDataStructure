package medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
	// 对数组进行全排列
	public List<List<Integer>> permute(int[] nums) {
		if(nums.length == 0)return new ArrayList<>();
		List<List<Integer>> allList = new ArrayList<>();
		helper(allList,new ArrayList<Integer>(),nums);
		return allList;
	}

	private void helper(List<List<Integer>> allList, ArrayList<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			allList.add(new ArrayList<Integer>(tempList));
		} else {
			for(int i = 0; i < nums.length; i ++) {
				if(tempList.contains(nums[i]))continue;
				tempList.add(nums[i]);
				helper(allList, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		
	}
}
