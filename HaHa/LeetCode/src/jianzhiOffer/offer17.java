package jianzhiOffer;

/*
 * 	HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)
 * ��	��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
 */
public class offer17 {
	public int FindGreatestSumOfSubArray(int[] array) {
		int res = array[0]; // ��¼��ǰ����������ĺ͵����ֵ
		int max = array[0]; // ����array[i]�������������ֵ
		for (int i = 1; i < array.length; i++) {
			max = Math.max(max + array[i], array[i]);
			res = Math.max(max, res); 
		}
		return max;
	}
	public static void main(String[] args) {
		int[] array = {4, -3, -2, 7, 8, -10, 2, 2};
		int[] array2 = {-1,2,3,-4,7};
		int a = new offer17().FindGreatestSumOfSubArray(array);
		System.out.println(a);
	}
}