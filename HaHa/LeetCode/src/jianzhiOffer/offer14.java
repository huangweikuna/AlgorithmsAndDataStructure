package jianzhiOffer;

/*
		����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
 * 
 */
public class offer14 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if(sequence.length == 0)return false;
		return isTrue(sequence, 0, sequence.length - 1);
	}

	private boolean isTrue(int[] arr, int l, int r) {
		int rootIndex = r;
		if(l < r) {
			while(l < r && arr[rootIndex] <= arr[r])--r;
			for(int i = l;i < r;i++) {
				if(arr[i] > arr[rootIndex])return false;
			}
			return isTrue(arr,r,rootIndex - 1) && isTrue(arr,l,r);
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		int arr[] = {5,4,3,2,1};
		System.out.println(new offer14().VerifySquenceOfBST(arr));
	}
}