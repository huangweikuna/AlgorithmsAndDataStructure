package sort;

public class MergeSort {
	// ��·�鲢�㷨�������ź���������кϲ�Ϊһ��������
	public void mergeSort(int[] arr, int s, int e) {
		if (s < e) {
			int mid = (e + s)/ 2;
			mergeSort(arr, s, mid);
			mergeSort(arr, mid + 1, e);
			merge(arr, s, mid, e);
		}
	}

	private void merge(int[] arr, int s, int mid, int e) {
		// TODO Auto-generated method stub
		int temp[] = new int[arr.length];
		int i = s, j = mid + 1;
		int t = 0;
		while (i <= mid && j <= e) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid)
			temp[t++] = arr[i++];
		while (j <= e)
			temp[t++] = arr[j++];
		t = 0;
		while (s <= e) {
			arr[s++] = temp[t++];
		}
	}

	public void test() {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
		mergeSort(a, 0, a.length - 1);
		System.out.println("�ź�������飺");
		for (int e : a)
			System.out.print(e + " ");
	}
}