package easy;

import java.util.ArrayList;
import java.util.List;
public class LeetCode448 {
	//����������û�г��ֵ�����   1-num.length()
	//��ÿһ��ֵһ��������״̬
	public List<Integer> findDisappearedNumbers(int[] nums) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i ++) {
			int val = Math.abs(nums[i]);
			if(nums[val] > 0) {
				nums[val] = - nums[val];
			}
		}
		for(int i = 0; i < nums.length; i ++) {
			if(nums[i] > 0) {
				list.add(i + 1);
			}
		}
		return list;
	}
}
