package jianzhiOffer;

import java.util.HashMap;

/*
	��Ŀ����
	LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
	��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣�
	��������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,
	����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ����
	 ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ�
	 ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
 */
public class offer22 {
	public boolean isContinuous(int[] numbers) {
		int [] count = new int[14];
		if(numbers.length == 0)
            return false;
		count[0] = -5;
		int max = -1;
		int min = 14;
		for(int i = 0 ; i < numbers.length; i ++) {
			count[numbers[i]] ++;
			if(numbers[i] == 0)
				continue;
			if(count[numbers[i]] > 1)return false;
			if(numbers[i] > max)max = numbers[i];
			if(numbers[i] < min)min = numbers[i];
		}
		if(max - min < 5)return true;
		else return false;
	}
	public static void main(String[] args) {
		int arr[] = {0,0,0,0,10};
		System.out.println(new offer22().isContinuous(arr));
	}
}