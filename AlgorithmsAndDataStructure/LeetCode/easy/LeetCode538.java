package easy;

import recursion.TreeNode;

public class LeetCode538 {
	//给定一个二进制搜索树（BST），将其转换为一个更大的树，这样原始BST的每个键都将更改为原始键加上大于BST中原始键的所有键的总和。
	public TreeNode convertBST(TreeNode root) {
		travel(root);
		return root;
	}
	int val = 0;
	public void travel(TreeNode root){
		if(root != null) {
			convertBST(root.right);
			root.val += val;
			val = root.val;
			convertBST(root.left);
		}
	}
}
