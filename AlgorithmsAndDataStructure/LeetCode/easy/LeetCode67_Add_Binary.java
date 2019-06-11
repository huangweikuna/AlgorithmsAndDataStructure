package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode67_Add_Binary {

	public String addBinary(String a, String b) {
        a = "0" + a;
        b = "0" + b;
        char []res = a.length() > b.length() ? a.toCharArray() : b.toCharArray();
        int al = a.length() - 1;
        int bl = b.length() - 1;
        int rl = res.length - 1;
        boolean carry = false;
        while(rl >= 0){
            if(a.charAt(al) == '1' && b.charAt(bl) == '1'){
                res[rl] = carry == true ? '1' : '0';
                carry = true;                
            } else if(a.charAt(al) == '0' && b.charAt(bl) == '0'){
                res[rl] = carry == true ? '1' : '0';
                carry = false;
            } else {
                res[rl] = carry == true ? '0' : '1';
            }
            if(al > 0)al --;
            if(bl > 0)bl --;
            rl --;
        }
        return res[0] == '0' ? new String(res).substring(1, res.length) : new String(res);
    }
	
	
	public static void main(String[] args) {
		String res = new LeetCode67_Add_Binary().replaceSpace(new StringBuffer("nihao a"));
		System.out.println(res);
	}
	public String toLowerCase(String str) {
        char res[] = new char[str.length()];
        for(int i = 0; i < res.length; i++){
            char c = str.charAt(i);
            res[i] = (char) ((c <= 'z' && c >= 'a') ? c : c + 32);
        }
        return res.toString();
    }
	public String replaceSpace(StringBuffer str) {
        if(str == null || str.toString().equals(""))return "";
        int count = 0;
		for(char c : str.toString().toCharArray())
            if(c == ' ')
                count++;
        char []res = new char[str.length() + 2 * count];
        int i = res.length - 1, j = str.length() - 1;
        while(i >= 0){
            char c = str.charAt(j --);
            if(c != ' '){
                res[i --] = c;
            }else{
                res[i--] = '0';
                res[i--] = '2';
                res[i--] = '%';
                count --;
            }
        }
        return new String(res);
    }
}
