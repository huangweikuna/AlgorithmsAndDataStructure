package jianzhiOffer;

/*
		输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
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