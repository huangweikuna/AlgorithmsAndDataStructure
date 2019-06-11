package easy;

import java.util.Arrays;

public class LeetCode198_House_Robber {
	int memo[];
	public int rob2(int[] nums) {
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return tryRob(nums,0);
	}

	private int tryRob(int[] nums, int index) {
		if(index >= nums.length)return 0;
		if(memo[index] != -1)return memo[index];
		int res = 0;
		for(int i = index;i < nums.length; i ++) {
			res = Math.max(res, nums[i] + tryRob(nums, i + 2));
		}
		memo[index] = res;
		return res;
	}
	public int rob(int[] nums){
        int n = nums.length;
        if(n == 0)return 0;
        memo = new int[n];
		Arrays.fill(memo, -1);
        
        memo[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i --) {
            for(int j = i; j < n; j ++) {
            	if(j == 0)memo[n - 1] = 0;
            	else memo[n - 1] = nums[n - 1];
                memo[i] = Math.max(memo[i],nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }
	public static void main(String[] args) {
		int res = new LeetCode198_House_Robber().rob(new int[] {3,2,6,8});
		System.out.println(res);
	}
}
