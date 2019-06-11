package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PrintMatrix {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix.length == 0)
			return new ArrayList<>();
		ArrayList<Integer> res = new ArrayList<>();
		
		int index = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		
		while(index * 2 < row && index * 2 < col) {
			printMatrix(res,matrix,index,row,col);
			++ index;
		}
		return res;
	}

	private void printMatrix(List<Integer> res,int[][] matrix, int index, int row, int col) {
		row = row - index - 1;
		col = col - index - 1;
		for(int i = index; i <= col; i ++) {
			res.add(matrix[index][i]);
		}
		if(index < row) {
			for(int i = index + 1; i <= row; i ++) {
				res.add(matrix[i][col]);
			}
		}
		if(index < row && index < col) {
			for(int i = col - 1; i >= index; i --) {
				res.add(matrix[row][i]);
			}
		}
		
		if(index < col && row - index > 1) {
			for(int i = row - 1; i >= index + 1; i --) {
				res.add(matrix[i][index]);
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		List<Integer> res = new PrintMatrix().printMatrix(arr);
		int c = 0;
		for(int n : res) {
			System.out.print(n + " ");
			if(++ c % arr[0].length == 0)
				System.out.println();
		}
		String a;
		ThreadLocalRandom.current().nextInt();
		System.out.println(0.1f == 0.1f);
		System.out.println(0.1f == 0.1d);
		System.out.println(0.1 == 0.1f);
		
		ThreadLocalRandom.current().nextInt(10);
		
	}
	int[] res;
	public int[] shuffle() {
        int temp[] = res.clone();
        List<Integer> list = new ArrayList<>();
        for(int n : temp)
            list.add(n);
        for(int i = 0; i < temp.length; i ++){
            temp[i] = list.remove(ThreadLocalRandom.current().nextInt(list.size() - 1));
        }
        return temp;
    }
}