package jianzhiOffer;

import java.util.ArrayList;

import stack_and_queue.TreeNode;

/*
		输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
		(注意: 在返回值的list中，数组长度大的数组靠前)
		
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
			//add添加的是引用  后面修改list时会影响结果
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