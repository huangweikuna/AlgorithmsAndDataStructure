package jianzhiOffer;

import stack_and_queue.TreeNode;

/*
		输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 */
public class offer11 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null)
			return false;
		return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || 
				HasSubtree(root1.right, root2);
	}

	private boolean isSubtree(TreeNode A, TreeNode B) {
		if (B == null)
			return true;
		if (A == null)
			return false;
		if (A.val == B.val) {
			return isSubtree(A.left, B.left) && 
					isSubtree(A.right, B.right);
		} else
			return false;
	}
}