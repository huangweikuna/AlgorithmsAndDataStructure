package jianzhiOffer;

/*
		һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * 
 */
public class offer5 {
	public int JumpFloor(int target) {
		if (target <= 0) {
			return -1;
		} else if (target == 1) {
			return 1;
		} else if (target == 2) {
			return 2;
		} else
			return JumpFloor(target - 1) + JumpFloor(target - 2);
	}
}