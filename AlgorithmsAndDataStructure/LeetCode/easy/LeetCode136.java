package easy;

public class LeetCode136 {
	// nums ������ÿ��Ԫ�س��ֶ��� ����һ����������һ�� �ҳ������

	//������ ���֮���ָ�Ϊԭ������
	public int singleNumber(int[] nums) {
		for(int i = 1; i < nums.length; i ++) {
			nums[0] ^= nums[i];  
		}
		return nums[0];
	}

	public static void main(String[] args) {
		int nums[] = { 1,0,1 };
		int res = new LeetCode136().singleNumber(nums);
		System.out.println(res);
	}
}
