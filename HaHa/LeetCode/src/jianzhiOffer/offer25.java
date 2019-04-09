package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
	从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class offer25 {
	ArrayList<ArrayList<Integer> > Print(TreeNode root) {
		ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
		if(root == null)return allList;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> list = new ArrayList<>();
			while(size > 0) {
				TreeNode node = q.remove();
				list.add(node.val);
				if(node.left != null)q.add(node.left);
				if(node.right != null)q.add(node.right);
				size --;
			}
			allList.add(list);
		}
		return allList;
    }
}