package sort;

public class HeapSort {
	public void heapSort(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			adjustHeap(arr, 0, i);
		}
	}

	private void adjustHeap(int[] arr, int s, int e) {
		int temp = arr[s];
		for (int i = 2 * s + 1; i < e; i = 2 * i + 1) {
			if(i + 1 < e && arr[i] < arr[i + 1])
				i ++;
			if(temp > arr[i])break;
			
			swap(arr, s ,i);
			s = i;
		}
	}

	private void swap(int[] arr, int i, int i2) {
		int temp = arr[i];
		arr[i] = arr[i2];
		arr[i2] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 1,12,2,3,2,11,23,12,44 };
		new HeapSort().heapSort(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
