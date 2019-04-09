package recursion;

/*
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * 
 * 		查找二分搜素树种的两个点最近的祖先
 */
public class LeetCode235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if(p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		if(p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		//如果不满足上面的条件  说明q , p 一个在root左边一个在root右边   
		//或者root == q 或者 root == p  这3种情况都直接返回root就可以了
		return root;
	}
}