package jianzhiOffer;

import java.util.HashMap;

/*
 * 	��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, 
 * 	���û���򷵻� -1����Ҫ���ִ�Сд��.
 */
public class offer21 {
	public int FirstNotRepeatingChar(String str) {
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);
		}
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(map.get(c) == 1)
				return i;
		}
		return -1;
    }
}