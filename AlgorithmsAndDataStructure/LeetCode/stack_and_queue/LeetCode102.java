package stack_and_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level). For example: Given binary tree
 * [3,9,20,null,null,15,7]---->[ [3], [9,20], [15,7] ]
 *
 */
//层序遍历所有结点
public class LeetCode102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int levelSize = q.size();
			List<Integer> currLevel = new ArrayList<>();
			//遍历该层的所有结点
			for(int i = 0; i < levelSize; i++) {
				TreeNode currNode = q.poll();
				currLevel.add(currNode.val);
				if (currNode.left != null)
					q.add(currNode.left);
				if (currNode.right != null)
					q.add(currNode.right);
			}
			res.add(currLevel);
		}
		return res;
	}
	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> currLevel = new ArrayList<>();
		res.add(currLevel);
		System.out.println(res.size());
		System.out.println(res);
		currLevel = new ArrayList<>();
		currLevel.add(3);
		res.add(currLevel);
		System.out.println(res);
	}
}
