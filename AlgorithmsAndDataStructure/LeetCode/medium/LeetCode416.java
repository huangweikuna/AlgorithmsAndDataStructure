package medium;

public class LeetCode416 {
	// �������Ƿ���Էֳ�������ͬ���Ӽ� �Ӽ������
	public boolean canPartition(int[] nums) {
		if (nums.length < 2)
			return false;
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if(sum % 2 != 0)return false;
		sum /= 2;
		//������������û�к�Ϊsum���Ӽ�
		
		
	}
}
