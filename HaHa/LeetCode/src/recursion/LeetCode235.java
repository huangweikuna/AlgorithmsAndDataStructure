package recursion;

/*
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * 
 * 		���Ҷ����������ֵ����������������
 */
public class LeetCode235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if(p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		if(p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		//������������������  ˵��q , p һ����root���һ����root�ұ�   
		//����root == q ���� root == p  ��3�������ֱ�ӷ���root�Ϳ�����
		return root;
	}
}