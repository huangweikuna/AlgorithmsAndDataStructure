package jianzhiOffer;

import java.util.HashMap;

/*
 * 	统计一个数字在排序数组中出现的次数。
 */
public class offer19 {
	public int GetNumberOfK(int[] arr, int k) {
		System.out.println(binarySearch(arr, k+0.5));
		System.out.println(binarySearch(arr, k-0.5));
		return binarySearch(arr, k+0.5) - binarySearch(arr, k-0.5) ;
	}

	private int binarySearch(int[] arr, double d) {
		int s = 0, e = arr.length - 1;
		while (s <= e) {
			int mid = (e - s) / 2 + s;
			if (arr[mid] < d)
				s = mid + 1;
			else if (arr[mid] > d)
				e = mid - 1;
		}
		return s;
	}
	public static void main(String[] args) {
		int []arr = {1,2,2,2,2,4};
		new offer19().GetNumberOfK(arr, 2);
	}
}