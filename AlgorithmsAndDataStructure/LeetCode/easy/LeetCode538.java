package easy;

import recursion.TreeNode;

public class LeetCode538 {
	//����һ����������������BST��������ת��Ϊһ���������������ԭʼBST��ÿ������������Ϊԭʼ�����ϴ���BST��ԭʼ�������м����ܺ͡�
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
