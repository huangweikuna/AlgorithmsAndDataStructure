package jianzhiOffer;

import java.util.ArrayList;

/*
 * 	С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * 	���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * 	���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 */
public class offer20 {
	//ʹ�û�������
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
		int left = 1,right = 2;
		while(left < right) {
			int toSum = (left + right) * (right - left + 1) / 2;
			if(toSum == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int i = left; i <= right ; i ++) {
					list.add(i);
				}
				allList.add(list);
				left++;
			}
			else if(toSum < sum)right++;
			else left++;
		}
		return allList;
    }
}