package recursion;

/*
 * 124. Binary Tree Maximum Path Sum
 * 
 * 	返回二叉树的最大路径和
 * 
 */
public class LeetCode124 {
	int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recode(root);
        return max;
    }
    private int recode(TreeNode node){
        if(node == null)return 0;
        int left = Math.max(0,recode(node.left));
        int right = Math.max(0,recode(node.right));
        
        max = Math.max(max , node.val + left + right);
        return node.val + Math.max(left , right);
    }
}