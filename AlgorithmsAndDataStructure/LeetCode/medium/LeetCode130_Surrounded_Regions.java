package medium;

import java.util.Arrays;

public class LeetCode130_Surrounded_Regions {
	//floodfill
	boolean isFlag[][];
    int m,n;
    int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    private boolean isArea(int x,int y){
        return x >=0 && y >= 0 && x < m && y < n;
    }
    private void flag(char[][]board, int x,int y,boolean flag){
        if(flag)board[x][y] = 'X';
        isFlag[x][y] = true;
        for(int i = 0; i < 4; i ++){
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if(isArea(newX,newY) && board[newX][newY] == 'O' && !isFlag[newX][newY])
                flag(board,newX,newY,flag);
        }
    }
    public void solve(char[][] board) {
        m = board.length;
        if(m == 0)return;
        n = board[0].length;
        isFlag = new boolean[m][n];
        for(int j=0; j<n; j++) {
            if(board[0][j]=='O') {
            	flag(board,0,j,false);
            }
            if(board[m-1][j]=='O') {
            	flag(board,m-1,j,false);
            }
        }
        for(int i=0; i<m; i++) {
            if(board[i][0]=='O') {
            	flag(board,i,0,false);
            }
            if(board[i][n-1]=='O') {
            	flag(board,i,n-1,false);
            }
        }
        for(int i = 1; i < m; i ++)
             for(int j = 1; j < n; j ++)
                if(board[i][j] == 'O' && !isFlag[i][j]){
                    flag(board,i,j,true);
                }
            
    }
    public static void main(String[] args) {
		char [][]res = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		new LeetCode130_Surrounded_Regions().solve(res);
		for(char []a : res)
			System.out.println(Arrays.toString(a));
	}
}
