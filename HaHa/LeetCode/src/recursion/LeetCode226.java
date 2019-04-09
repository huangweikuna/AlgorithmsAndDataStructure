package recursion;

/*
 * 226. Invert Binary Tree
 * 		·­×ªÁ½¿Ã¶þ²æÊ÷
 * 
 * 
Input:

		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
Output:
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
 */
public class LeetCode226 {
	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		invertTree(root.left);
		invertTree(root.right);
		TreeNode node = new TreeNode(0);
		node = root.right;
		root.right = root.left;
		root.left = node;
		return root;
	}
}