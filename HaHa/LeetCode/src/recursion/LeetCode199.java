package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 199. Binary Tree Right Side View
 * 
 * 
 * 		Input: [1,2,3,null,5,null,4]
		Output: [1, 3, 4]
		Explanation:
		
		   1            <---
		 /   \
		2     3         <---
		 \     \
		  5     4       <---
 */
public class LeetCode199 {
	public List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				TreeNode node = q.poll();
				if (size == 1)
					list.add(node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				size--;
			}
		}

		return list;
	}
}