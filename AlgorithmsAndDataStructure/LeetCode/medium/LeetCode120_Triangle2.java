package medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode120_Triangle2 {
	public int minimumTotal(List<List<Integer>> triangle) {
		for(int i = triangle.size() - 1; i >= 1 ; i --) {
			for(int j = 0; j <= triangle.get(i).size() - 2; j ++) {
				triangle.get(i - 1).set(j, triangle.get(i - 1).get(j) + Math.min(triangle.get(i).get(j),triangle.get(i).get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}
	public static void main(String[] args) {
		int a[][] = {{-1},{2,3},{-1,-1,-3},{4,4,3,4}};
		List<List<Integer>> triangle = new ArrayList<>();
		for(int []t : a) {
			List<Integer> list = new ArrayList<>();
			for(int i : t) {
				list.add(i);
			}
			triangle.add(list);
		}
		
		int res = new LeetCode120_Triangle2().minimumTotal(triangle);
		System.out.println(res);
		System.out.println(triangle.toString());
	}
}
