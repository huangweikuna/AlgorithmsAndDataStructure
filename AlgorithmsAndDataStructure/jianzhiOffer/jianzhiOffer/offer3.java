package jianzhiOffer;

/*
 * 	输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 	例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class offer3 {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0)
			return null;
		return ConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	// {1,2,4,7,3,5,6,8} 前序遍历 1 是根 (第一个元素)
	// {4,7,2,1,5,3,8,6} {4,7,2 (左孩子)1(右孩子) 5,3,8,6} 进行递归
	private TreeNode ConstructBinaryTree(int[] pre, int i, int length, int[] in, int j, int length2) {
		if (i > length || j > length2)
			return null;
		TreeNode root = new TreeNode(pre[i]);
		for (int k = j; k <= length2; k++) {
			if (in[k] == pre[i]) {
				root.left = ConstructBinaryTree(pre, i + 1, k - j + i, in, j, k - 1);
				root.right = ConstructBinaryTree(pre, k - j + i + 1, length, in, k + 1, length2);
				break;
			}
		}
		return root;
	}
}