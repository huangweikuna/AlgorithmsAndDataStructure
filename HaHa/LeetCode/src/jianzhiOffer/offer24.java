package jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/*
	请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
	第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class offer24 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
		ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
	    if(root == null)return allList;
	    Stack<TreeNode> stack1 = new Stack<>();
	    Stack<TreeNode> stack2 = new Stack<>();
	    
	    stack1.push(root);
	    while(!stack1.isEmpty() || !stack2.isEmpty()) {
	    	if(!stack1.isEmpty()) {
	    		ArrayList<Integer> list = new ArrayList<>();
	    		while(!stack1.isEmpty()) {
	    			TreeNode node = stack1.pop();
	    			list.add(node.val);
	    			if(node.left != null)
	    				stack2.push(node.left);
	    			if(node.right != null)
	    				stack2.push(node.right);
	    		}
	    		allList.add(list);
	    	}
	    	else if(!stack2.isEmpty()){
	    		ArrayList<Integer> list = new ArrayList<>();
	    		while(!stack2.isEmpty()) {
	    			TreeNode node = stack2.pop();
	    			list.add(node.val);
	    			if(node.right != null)
	    				stack1.push(node.right);
	    			if(node.left != null)
	    				stack1.push(node.left);
	    		}
	    		allList.add(list);
	    	}
	    }
	    return allList;
    }
}