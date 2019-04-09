package jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/*
	��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ��
	�����а��մ����ҵ�˳���ӡ���������Դ����ơ�
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