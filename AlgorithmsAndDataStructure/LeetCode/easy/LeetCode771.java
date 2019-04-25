package easy;

public class LeetCode771 {
	//ͳ��S�к���z���ַ�����Ŀ  j�е���ĸ��֤�ǲ�ͬ�ģ�j��s�е������ַ�������ĸ����ĸ�����ִ�Сд��
	public int numJewelsInStones(String J, String S) {
		if(J.length() <= 0 || S.length() <= 0)
			return 0;
		int arr[] = new int[256];
		int count = 0;
		for(int i = 0; i < J.length(); i ++) {
			arr[S.charAt(i)]++;
		}
		for(int i = 0; i < S.length(); i ++) {
			if(arr[J.charAt(i)] > 0)
				count ++;
		}
		return count;
	}
}
