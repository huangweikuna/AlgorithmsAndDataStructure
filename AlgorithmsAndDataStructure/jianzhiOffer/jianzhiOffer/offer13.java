package jianzhiOffer;

import java.util.Stack;

/*
		���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
		��������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
		��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 * 
 */
public class offer13 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if(pushA.length <= 0 || popA.length <=0 || pushA.length != popA.length)
			return false;
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for(int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while(!stack.isEmpty() && stack.peek() == popA[index]) {
				stack.pop();
				index ++;
			}
		}
		return stack.isEmpty();
	}
}