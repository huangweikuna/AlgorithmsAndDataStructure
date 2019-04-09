package integers_move;
/**
 * 
 * @author Administrator Given a sorted array nums, remove the duplicates
 *         in-place such that duplicates appeared at most twice and return the
 *         new length. Do not allocate extra space for another array, you must
 *         do this by modifying the input array in-place with O(1) extra memory.
 */
//���������е��ظ�Ԫ��
//�ظ�Ԫ�������������  ������ͬ26��  ֻ���ظ���Ԫ�ؿ��Գ�������  ������������һ��flag��ʶԪ�س��ֵĴ���
public class LeetCode80 {
	public int removeDuplicates(int[] nums) {
		int flag = 0;
		if (nums.length == 0)
			return 0;
		int i = 0;
		// ����ָ��i,j�ֱ�����㿪ʼ j�������û���ظ� ���滻i+1�� (�������ظ�����Ϊ2) ����flag��ʶ�ظ����ֵĸ��� ���������ͬ������������
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
				flag = 0;
			} else {
				if (++flag < 2) {
					i++;
					nums[i] = nums[j];
					continue;
				}

			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 2 };
		LeetCode80 test = new LeetCode80();
		System.out.println(test.removeDuplicates(nums));
	}
}
