package jianzhiOffer;

import java.util.Stack;

/*
		����ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * 
 */
public class offer4 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	while(!stack2.isEmpty())
        	stack1.push(stack2.pop());
    	//���Ƚ���������   �����Ƴ�Stack2 ��Ԫ�ص�stack1  ��node���뵽ջ��  ֮��������ԭ����Ԫ��
        stack2.push(node);
        while(!stack1.isEmpty())
        	stack2.push(stack1.pop());
    }
    public int pop() {
    	return stack2.pop();
    }
}