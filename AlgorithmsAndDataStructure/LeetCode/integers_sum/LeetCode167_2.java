package integers_sum;

/*  Input: numbers = [2,7,11,15], target = 9
 *	Output: [1,2]
 *	Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class LeetCode167_2 {
	// 题目中是升序数组 所以可以使用指针碰撞 时间复杂度O(n)
	public int[] twoSum(int[] numbers, int target) {
		int[] result = { 0, 0 };
		int right = numbers.length - 1, left = 0;
		while (right >= left) {
			if (numbers[right] + numbers[left] == target) {
				result[0] = left + 1;
				result[1] = right + 1;
				break;
			} else  if(numbers[right] + numbers[left] < target){
				left ++;
			} else {
				right --;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		LeetCode167_2 test = new LeetCode167_2();
		int[] result = test.twoSum(nums, 6);
		System.out.println(result[0] + "  ---   " + result[1]);
	}
}
