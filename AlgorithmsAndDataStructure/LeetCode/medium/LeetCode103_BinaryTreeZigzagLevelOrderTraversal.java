package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import recursion.TreeNode;

public class LeetCode103_BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)return res;
		
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		
		stack1.add(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<>();
			if(!stack1.isEmpty()) {
				while(!stack1.isEmpty()) {
					TreeNode node = stack1.pop();
					list.add(node.val);
					if(node.left != null)stack2.add(node.left);
					if(node.right != null)stack2.add(node.right);
				}
				res.add(new ArrayList<>(list));
			} else {
				while(!stack2.isEmpty()) {
					TreeNode node = stack2.pop();
					list.add(node.val);
					if(node.right != null)stack1.add(node.right);
					if(node.left != null)stack1.add(node.left);
				}
				res.add(new ArrayList<>(list));
			}
		}
		return res;
	}
	public static void main(String[] args) {
	}
}
