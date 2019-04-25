package easy;

// 找一个最短子串排序  排序之后使得整个数组也是有序的   可以重复并且升序
public class LeetCode581 {
	public int findUnsortedSubarray(int[] nums) {
		int begin = nums.length;
		int end = 0;
		if (nums.length <= 1)
			return 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int temp = nums[i];
			if (temp > nums[i + 1]) {
//				System.out.println(i + "   " + (i + 1));
				while (i < nums.length - 1 && temp > nums[i + 1]) {
					end = Math.max(end, i + 1);
					begin = Math.min(begin, i);
					i++;
				}
			}
		}
//		System.out.println(begin + "   " + end);
		if (begin == nums.length)
			return 0;
		return end - begin + 1;
	}

	public static void main(String[] args) {
		int arr[] = { 1,3,2,3,3 };
		int res = new LeetCode581().findUnsortedSubarray(arr);
		System.out.println(res);
	}
}
