package jianzhiOffer;

/*
		����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
		���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * 
 */
public class offer7 {
	//ʹ��ð���㷨  ǰż����ͽ���
	public void reOrderArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 1; j < array.length - i; j++) {
				if(array[j - 1] % 2 == 0 &&
						array[j] % 2 != 0) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}
}