package test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public void test() {
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer,Integer> mapR = new HashMap<>();
//		int arr[] = new int[n];
		int arr[] = {1};
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
//			arr[i] = scan.nextInt();
			set.add(arr[i]);
		}
		int length = -1;
		int l = 0,r = 0;
		String res = "";
		int num = 0;
		while(r < arr.length) {
			count = mapR.getOrDefault(arr[r], 0);
			mapR.put(arr[r], count + 1);
			while(l <= r && mapR.size() == set.size()) {
				if(length == -1 || length >= r - l + 1) {
					if(length > r - l + 1) {
						res = "";
						num = 0;
					}
					length = r - l + 1;
					res += "[" + (l + 1) + "," + (r + 1) + "] ";
					num ++;
//					System.out.println((l + 1) + " --->" + (r + 1));
				}
				count = mapR.get(arr[l]);
				mapR.put(arr[l], count - 1);
				if(mapR.get(arr[l]).intValue() == 0)
					mapR.remove(arr[l]);
				l ++;
			}
			r++;
		}
		if(arr.length == 0) {
			return;
		}
		System.out.println(length + " " + num);
		System.out.println(res.substring(0,res.length() - 1));
	}
	public static void main(String[] args) {
		new Solution().test();
	}
}