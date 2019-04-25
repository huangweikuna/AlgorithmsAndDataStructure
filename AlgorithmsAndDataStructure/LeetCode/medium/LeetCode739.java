package medium;

import java.util.Stack;

public class LeetCode739 {
	// 找到第一个比它大的数
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int res[] = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
				res[stack.peek()] = i - stack.pop();
			}
			stack.push(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int res[] = new LeetCode739().dailyTemperatures(arr);
		for (int n : res) {
			System.out.println(n);
		}
	}
}
