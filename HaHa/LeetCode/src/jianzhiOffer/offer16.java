package jianzhiOffer;

import java.util.ArrayList;

import stack_and_queue.TreeNode;

/*
		����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
		(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
		
 * 
 */
public class offer16 {
	ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
	ArrayList<Integer> list = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null)
			return listAll;
		list.add(root.val);
		target = target - root.val;
		if (root.left == null && root.right == null && target == 0)
			//add��ӵ�������  �����޸�listʱ��Ӱ����
			listAll.add(new ArrayList<>(list));
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size() - 1);
		return listAll;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}