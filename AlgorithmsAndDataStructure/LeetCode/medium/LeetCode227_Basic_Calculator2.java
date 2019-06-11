package medium;

import java.util.Stack;

public class LeetCode227_Basic_Calculator2 {
	// ʵ�� �Ӽ��˳��Ļ������� 1 + 2 * 3
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		String num = "";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ')continue;
			
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				//�����Ĵ�����з��ŵ�����
				//���  1 + 2 - 3
				//�� push 1, +2 , -3
				if(!num.equals(""))
					stack.push(Integer.parseInt(num));
				num = "";
				num += s.charAt(i);
			} else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
				//������������� * �� /�� ��ȡ��stack�е����ݼ��� 
				//����ǵ�һ������ * �� / ��ֱ��ʹ��num�е�ֵ�ͺ����ֵ����
				int temp;
				if(num.equals(""))
					temp = stack.pop();
				else
					temp = Integer.parseInt(num);
				num = "";
				char c = s.charAt(i++);
				//������ֵ���м���
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
