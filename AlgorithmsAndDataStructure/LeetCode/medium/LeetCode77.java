package medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
	// ��ѯn��������ѡ��k�����ֵ��������
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
		//��֦����
		//���� k - list.size() ����λ������, [ i ... n] ������Ҫ�� k - list.size()��Ԫ��
		//i ���Ϊ n - (k - list.size()) + 1
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
