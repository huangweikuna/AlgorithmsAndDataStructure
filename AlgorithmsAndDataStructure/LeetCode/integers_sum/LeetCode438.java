package integers_sum;

import java.util.ArrayList;
import java.util.List;

/*  
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
 */

//�������һ���ַ��� s  p = "abc"   ������s�����е� p�ı�λ�ʵĳ�ʼ����  �� abc acb bac bca cab cba 
public class LeetCode438 {
	public List<Integer> findAnagrams(String s, String p) {
		// ʹ�û�������
		List<Integer> res = new ArrayList<>();
		//s�ĳ���һ��Ҫ��p���Ĵ�
        if (s.length() < p.length()) {
            return res;
        }
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
        }
        int l = 0, r = -1;
        while (r + 1 < s.length()) {
        	//ȷ���ַ�����ƥ��
			freqS[s.charAt(++r) - 'a']++;
			//ȷ����ӽ������ַ������Ǻ�p �е�����ַ���������ȵ�
			//��������  �����ƶ�l  ֪��������ַ��Ƴ������Ϊֹ
			while (freqS[s.charAt(r) - 'a'] > freqP[s.charAt(r) - 'a']) {
                freqS[s.charAt(l++) - 'a']--;
            }
            //����Ĵ���ȷ���ַ�����ƥ��
			//��˼�� ���r - l + 1 Ҳ����r �� l ֮����ַ�����������p�ĳ���    ��������ÿ���ַ����������Ǻ�p�е�������ͬ  ��ô���ǾͿ��Եõ�һ����
			if (r - l + 1 == p.length()) {
                res.add(l);
            }
		}
        return res;
	}

	public static void main(String[] args) {
		LeetCode438 test = new LeetCode438();
		String s = "cbaebabacd";
		System.out.println(test.findAnagrams(s, "abc"));
	}
}
