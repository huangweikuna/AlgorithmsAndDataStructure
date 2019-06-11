package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		int []res = {-4,-1,0,3,10};
		res = new Main().sortedSquares(res);
		System.out.println(res);
		
		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}
		for(int i = 0; i < 2; i ++) {
			list.remove(i);set.remove(i);
			
		}
		System.out.println(list + " " + set);
	}
	public int[] sortedSquares(int[] A) {
        int r = 0;
        while(r < A.length && A[r] < 0){
            r ++;
        }
        int index = r - 1;
        int res[] = new int[A.length];
        int i = 0;
        while(index >= 0 && r < A.length){
            res[i ++] = A[index] * A[index] < A[r] * A[r] ? A[index] * A[index --] : A[r] * A[r ++];
        }
        while(index >= 0)
            res[i ++] = A[index] * A[index--];
        while(r < A.length)
            res[i ++] = A[r] * A[r ++];
        return res;
    }
}
