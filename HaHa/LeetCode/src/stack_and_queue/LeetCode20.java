package stack_and_queue;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. ¿®∫≈∆•≈‰
 */
public class LeetCode20 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else if (stack.isEmpty()) {
				return false;
			} else {
				switch (s.charAt(i)) {
				case ')':
					if (stack.pop() != '(')
						return false;
					break;
				case ']':
					if (stack.pop() != '[')
						return false;
					break;
				case '}':
					if (stack.pop() != '}')
						return false;
					break;
				default:
					return false;
				}
			}
		}
		if (stack.isEmpty())
			return true;
		return false;
	}
}
/*

*/