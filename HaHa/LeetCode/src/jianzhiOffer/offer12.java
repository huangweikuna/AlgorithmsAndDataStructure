package jianzhiOffer;

import java.util.Stack;

import stack_and_queue.TreeNode;

/*
		���������Ķ�����������任ΪԴ�������ľ���
 * 
 */
public class offer12 {
	public void Mirror(TreeNode root) {
		if(root == null)return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}
}
//Stack<Integer> stack = new Stack<>();
//Stack<Integer> stack2 = new Stack<>();
//public void push(int node) {
//    stack.push(node);
//    if(stack2.isEmpty())
//        stack2.push(node);
//    else{
//        if(node <= stack2.peek())
//            stack2.push(node);
//    }
//}
//
//public void pop() {
//    if(stack.peek() == stack2.peek())
//        stack2.pop();
//    stack.pop();
//}
//
//public int top() {
//    return stack.peek();
//}
//
//public int min() {
//    return stack2.peek();
//}