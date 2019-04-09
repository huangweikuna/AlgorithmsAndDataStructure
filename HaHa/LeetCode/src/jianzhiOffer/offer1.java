package jianzhiOffer;

public class offer1 {
	public boolean Find(int target, int[][] array) {
		for (int i = 0; i < array.length; i++) {
			if (binarySearch(array[i], target))
				return true;
		}
		return false;
	}

	public boolean binarySearch(int[] arr, int target) {
		int i = 0, j = arr.length - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (target == arr[mid])
				return true;
			else if (target > arr[mid])
				i = mid + 1;
			else
				j = mid - 1;
		}
		return false;
	}
}