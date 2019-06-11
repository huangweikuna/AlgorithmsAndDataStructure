package medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
	// 查询n个数字中选出k个数字的所有组合
	List<List<Integer>> allList = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		if (n == 0)
			return new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(list, 1, n, k);
		return allList;
	}

	private void helper(List<Integer> list, int index, int n, int k) {
		if (list.size() == k) {
			allList.add(new ArrayList<>(list));
			return;
		}
		//剪枝操作
		//还有 k - list.size() 个空位，所以, [ i ... n] 中至少要有 k - list.size()个元素
		//i 最多为 n - (k - list.size()) + 1
		for (int i = index; i <= n - (k - list.size()) + 1; i++) {
			list.add(i);
			helper(list, i + 1, n , k);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {

		List<List<Integer>> res = new LeetCode77().combine(4,2);
		System.out.println(res.toString());
 	}
}
