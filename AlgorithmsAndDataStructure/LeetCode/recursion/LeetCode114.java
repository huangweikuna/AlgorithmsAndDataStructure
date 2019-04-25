package recursion;

/*
 * 114. Flatten Binary Tree to Linked List
 * 
 * 
 * 		讲二叉树摊开成链表
 */
public class LeetCode114 {
	   public void flatten(TreeNode root) {
	        if(root == null)return;
	        if(root.left != null)flatten(root.left);
	        if(root.right != null)flatten(root.right);
	        
	        //把左子树放到右子树上  右子树接到最后面
	        TreeNode temp = root.right;
	        root.right = root.left;
	        root.left = null;
	        while(root.right != null)root = root.right;
	        root.right = temp;
	        
	        
	    }
}