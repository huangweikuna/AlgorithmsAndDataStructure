package integers_sum;

/*  
 *  209. Minimum Size Subarray Sum
	Given an array of n positive integers and a positive integer s, find the minimal length
	 of a contiguous subarray of which the sum �� s. If there isn't one, return 0 instead.
	Example: 
	Input: s = 7, nums = [2,3,1,2,4,3]
	Output: 2
	Explanation: the subarray [4,3] has the minimal length under the problem constraint.
	//����һ������  Ҫ�����������ҵ���������С���ȵ�������(������ĺ�Ϊ sums) 
 */
public class LeetCode209 {
	public int minSubArrayLen(int s, int[] nums) {
		// ʹ�û�������
		int l = 0, r = -1;
		// ���û�δ�ƶ����ļ��
		int minIndex = nums.length + 1;
		int sum = 0;
		while (l <= nums.length - 1) {
			// ˵��r�����Լ����ƶ�
			if (r + 1 < nums.length && sum < s) {
				r++;
				sum += nums[r];
			} else {
				sum -= nums[l];
				l++;
			}
			//������Сֵ
			if (sum >= s) {
				if (minIndex > r - l + 1)
					minIndex = r - l + 1;
			}
		}
		//˵������������������������
		if(minIndex == nums.length + 1)
			return 0;
		return minIndex;
	}

	public static void main(String[] args) {
		LeetCode209 test = new LeetCode209();
		int[] nums = {};
		System.out.println(test.minSubArrayLen(7, nums));
	}
}
