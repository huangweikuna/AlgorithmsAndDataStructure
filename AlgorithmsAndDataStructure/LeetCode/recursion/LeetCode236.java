package recursion;

/*
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * 
 * 		查找二叉种的两个点最近的祖先
 */
public class LeetCode236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || q == root || p == root)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
}