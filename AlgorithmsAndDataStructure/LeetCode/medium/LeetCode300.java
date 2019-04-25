package medium;

public class LeetCode300 {
	public int lengthOfLIS(int[] nums) {
		int res[] = new int[nums.length];
		int size = 0;
		for (int n : nums) {
			int i = 0, j = size;
			while (i != j) {
				int mid = (i + j) / 2;
				if (n > nums[mid])
					i = mid + 1;
				else
					j = mid;
			}
			res[i] = n;
			if (i == size)
				size++;
		}
		return size;
	}
	
}
