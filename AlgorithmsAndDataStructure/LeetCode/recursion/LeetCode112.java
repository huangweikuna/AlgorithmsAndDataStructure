package recursion;

/*
 * 112. Path Sum
 * 
 * 
 * 
 * Given the below binary tree and sum = 22,
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \      \
	7    2      1
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	//判断是否存在从根节点出发到叶子节点的路径和为sum
 */
public class LeetCode112 {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        	return false;
        if( root.left == null && root.right == null)
        	return sum - root.val == 0;
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}