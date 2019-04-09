package integers_sum;

import java.util.Arrays;
/*    使用二分法辅助   遍历数组 之后用二分法查找剩余数组是否有 target-number[i]的值
 *                         二分法函数返回的是找到结果之后的下标  出来之后在计算目标下标   复杂度为O(nlogn)
 *  Input: numbers = [2,7,11,15], target = 9
 *	Output: [1,2]
 *	Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class LeetCode167 {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = { 0, 0 };
		for (int i = 0; i < numbers.length; i++) {
			//copyOfRange 是获取数组的 [ i ... j )的元素
			int index = bitarySearch(Arrays.copyOfRange(numbers, i + 1, numbers.length),target - numbers[i]);
			if(index != -1) {
				//返回下标要求从1开始  所以都多加上1
				result[0] = i + 1;
				result[1] = i + index + 1 + 1;
				return result;
			}
		}
		return null;
	}
	// 二分查找
	public int bitarySearch(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (numbers[mid] == target) {
				//返回下标
				return mid;
			} else if (numbers[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums = { 1, 2,3,4};
		LeetCode167 test = new LeetCode167();
		int []result = test.twoSum(nums,6);
		System.out.println(result[0] + "  ---   " + result[1]);
	}
}
