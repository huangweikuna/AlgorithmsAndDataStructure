package recursion;

/*
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * 
 * 		���Ҷ����ֵ����������������
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