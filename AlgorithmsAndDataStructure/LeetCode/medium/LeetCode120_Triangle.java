package medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode120_Triangle {
	int n = Integer.MAX_VALUE;
	public int minimumTotal(List<List<Integer>> triangle) {
		find(triangle, 0, 0,0);
		return n;
	}

	private void find(List<List<Integer>> triangle, int index, int sum,int k) {
		if (index == triangle.size()) {
			n = Math.min(n, sum);
			return;
		}
		List<Integer> list = triangle.get(index);
		for (int i = k; i < list.size() && (i <= k + 1); i++) {
			sum += list.get(i);
			find(triangle,index + 1,sum,i);
			sum -= list.get(i);
		}
	}
	
	public static void main(String[] args) {
		int a[][] = {{-1},{2,3},{-1,-1,-3}};
		List<List<Integer>> triangle = new ArrayList<>();
		for(int []t : a) {
			List<Integer> list = new ArrayList<>();
			for(int i : t) {
				list.add(i);
			}
			triangle.add(list);
		}
		int res = new LeetCode120_Triangle().minimumTotal(triangle);
		System.out.println(res);
	}
}
