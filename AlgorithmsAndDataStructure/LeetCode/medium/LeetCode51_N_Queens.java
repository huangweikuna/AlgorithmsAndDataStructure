package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51_N_Queens {
	List<List<String>> res = new ArrayList<>();
    boolean []col;
    boolean []dia1;
    boolean []dia2;
    private void listToString(List<Integer> list,int n){
        List<String> s = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < n; j ++)
                sb.append(j == list.get(i) ? "Q" : ".");
            s.add(sb.toString());
        }
        res.add(s);
    }
    private void putQueen(int n,int index,List<Integer> list){
        if(index == n){
            System.out.println(list.toString());
            listToString(list,n);
            return;
        }
        for(int i = 0; i < n; i ++){
            if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
                list.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1,list);
                list.remove(list.size() - 1);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        if(n <= 0)return res;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        putQueen(n,0,new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {
    	List<List<String>> res = new LeetCode51_N_Queens().solveNQueens(4);
    	for(List<String> s : res) {
    		for(String ss : s)
    			System.out.println(ss);
    	}
	}
}
