package jianzhiOffer;

import java.util.Stack;

/*
		两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 */
public class offer4 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	while(!stack2.isEmpty())
        	stack1.push(stack2.pop());
    	//最先进来的最后出   所以移除Stack2 的元素到stack1  把node放入到栈底  之后在移入原来的元素
        stack2.push(node);
        while(!stack1.isEmpty())
        	stack2.push(stack1.pop());
    }
    public int pop() {
    	return stack2.pop();
    }
}