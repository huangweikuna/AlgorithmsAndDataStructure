package jianzhiOffer;

/*
 * 	����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * 	��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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

	// {1,2,4,7,3,5,6,8} ǰ����� 1 �Ǹ� (��һ��Ԫ��)
	// {4,7,2,1,5,3,8,6} {4,7,2 (����)1(�Һ���) 5,3,8,6} ���еݹ�
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