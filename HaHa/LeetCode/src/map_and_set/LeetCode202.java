package map_and_set;

import java.util.ArrayList;
import java.util.List;

/**
 * 202. Happy Number Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers. Example: Input:
 * 19 Output: true Explanation: 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02
 * + 02 = 1
 */
public class LeetCode202 {
	public boolean isHappy(int n) {
		String num = n + "";
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num.length(); i++) {
			sum += (num.charAt(i) - '0') * (num.charAt(i) - '0');
			if (i + 1 == num.length() && sum == 1) {
				return true;
			}
			if (i + 1 == num.length() && sum != 1) {
				if(list.contains(sum)) 
					return false;
				else
					list.add(sum);
				i = -1;
				num = sum + "";
				sum = 0;
			}
		}
		return false;
	}
	/*
	 * 	完全使用数学计算  1ms
	 * public boolean isHappy(int n) {
		    for (int sum = 0; n / 10 != 0 || n % 2 != 0 || (n == 1); n = sum, sum = 0) {
		        for (int i = n; i > 0; i /= 10)
		            sum += Math.pow(i % 10, 2);
		        if (sum == 1)
		            return true;
		    }
		    return false;
	   }
}
	 */
	public static void main(String[] args) {
		LeetCode202 test = new LeetCode202();
		System.out.println(test.isHappy(19));
	}
}
