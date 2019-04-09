package sort;

public class BubbleSort {
	public void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		int[] arr = {2,23,43,4,23,32,1,2,1};
		new BubbleSort().bubbleSort(arr);
	}
}