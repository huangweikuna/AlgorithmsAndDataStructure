package integers_move;
//���������еĹ涨����val
//������δ��������
public class LeetCode27 {
	//ʹ��˫ָ��  ����������ŵ������ĩβ
	public int removeElement(int[] nums, int val) {
		int l = 0, r = nums.length -1;
		while(l <= r) {
			if(nums[l] == val) {
				int temp = nums[l];
				nums[l] = nums[r];
				nums[r] = temp;
				r--;
			}else {
				l++;
			}
		}
		return l;
	}
	public static void main(String[] args) {
		int []nums = {1};
		LeetCode27 test = new LeetCode27();
		System.out.println(test.removeElement(nums,1));
	}
}
