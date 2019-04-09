package integers_move;
/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 */
//���������е��ظ�Ԫ��
public class LeetCode26 {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		//�ú��治�ظ��������滻ǰ���ظ�������    i��¼�ظ����ֵ��±�   j��ɨ�費�ظ�������
		//����ֻ�ܽ�������������
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2 ,2,2};
		LeetCode26 test = new LeetCode26();
		System.out.println(test.removeDuplicates(nums));
	}
}
