package recursion;

/*
 * 104. Maximum Depth of Binary Tree
 * 		���ض�������������
 */
public class LeetCode104 {
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}