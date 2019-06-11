package medium;

public class LeetCode227_Basic_Calculator2_moreFast {
	// 实现 加减乘除的基本运算 1 + 2 * 3
	public int calculate(String s) {
		int pre = 0, cur = 0, sum = 0;
		char sign = '+';
		char[] arr = s.trim().toCharArray();
		for (int i = 0; i <= arr.length; i++) {
			if (i != arr.length && Character.isDigit(arr[i])) {
				cur = cur * 10 + (arr[i] - '0');
				continue;
			}
			else {
				if (i != arr.length && arr[i] == ' ')
					continue;
				if (sign == '+') {
					sum += cur;
					pre = cur;
				} else if (sign == '-') {
					sum -= cur;
					pre = -cur;
				} else if (sign == '*') {
					sum = sum - pre + pre * cur;
					pre *= cur;
				} else if (sign == '/') {
					sum = sum - pre + pre / cur;
					pre /= cur;
				}
				cur = 0;
				if (i != arr.length)
					sign = arr[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {

		int res = new LeetCode227_Basic_Calculator2_moreFast().calculate("1 + 2 * 4 + 1 + 2");
		System.out.println(res);
	}
}
