package medium;

public class LeetCode5 {
	// 查询最长回文子串
	public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i ++){
            String s1 = expSearch(s,i,i);
            String s2 = expSearch(s,i,i + 1);
            String temp = s1.length() > s2.length() ? s1 : s2;
            if(res.length() < temp.length())
            	res = temp;
        }
        return res;
    }
    private String expSearch(String s,int i,int j){
    	String res = "";
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
        	res = s.substring(i,j + 1);
            i--;
            j++;
        }
        return res;
    }

	public static void main(String[] args) {
		String res = new LeetCode5().longestPalindrome("babad");
		System.out.println(res);
	}
}
