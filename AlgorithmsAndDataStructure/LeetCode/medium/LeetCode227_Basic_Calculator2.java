package medium;

import java.util.Stack;

public class LeetCode227_Basic_Calculator2 {
	// 实现 加减乘除的基本运算 1 + 2 * 3
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		String num = "";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ')continue;
			
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				//连续的存入带有符号的整数
				//如果  1 + 2 - 3
				//则 push 1, +2 , -3
				if(!num.equals(""))
					stack.push(Integer.parseInt(num));
				num = "";
				num += s.charAt(i);
			} else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
				//如果遇到连续的 * 或 /法 则取出stack中的数据计算 
				//如果是第一次遇到 * 或 / 则直接使用num中的值和后面的值计算
				int temp;
				if(num.equals(""))
					temp = stack.pop();
				else
					temp = Integer.parseInt(num);
				num = "";
				char c = s.charAt(i++);
				//与后面的值进行计算
				while(i  < s.length() && s.charAt(i) != '+'
						&& s.charAt(i) != '-'
						&& s.charAt(i) != '*'
						&& s.charAt(i) != '/'
						) {
					if(s.charAt(i) == ' ') {i++;continue;}
					num += s.charAt(i++);
				}
				stack.push(c == '*' ? temp * Integer.parseInt(num) : temp / Integer.parseInt(num));
				i--;
				num = "";
			} else {
				num += s.charAt(i);
			}
			if (i + 1 == s.length() && !num.equals(""))
				stack.push(Integer.parseInt(num));
		}
		if (stack.isEmpty())
			return Integer.parseInt(num);
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}

	public int count(int a, int b, char ch) {
		switch (ch) {
		case '/':
			return a / b;
		default:
			return a * b;
		}
	}

	public static void main(String[] args) {
		
		
		int res = new LeetCode227_Basic_Calculator2().calculate("1 + 2 * 4 *1");
		System.out.println(res);
	}
}
