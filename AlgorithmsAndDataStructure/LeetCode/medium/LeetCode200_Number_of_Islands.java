package medium;

public class LeetCode200_Number_of_Islands {
	//floodfill
	boolean isLand[][];
    int m,n;
    int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    private boolean isArea(int x,int y){
        return x >=0 && y >= 0 && x < m && y < n;
    }
    private void flag(char[][]grid, int x,int y){
        isLand[x][y] = true;
        for(int i = 0; i < 4; i ++){
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if( isArea(newX,newY) && !isLand[newX][newY] && grid[newX][newY] == '1')
                flag(grid,newX,newY);
        }
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0)return 0;
        n = grid[0].length;
        isLand = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < grid.length; i ++)
            for(int j = 0; j < grid[i].length; j ++){
                if(grid[i][j] == '1' && !isLand[i][j]){
                     count ++;
                    flag(grid,i,j);
                }
            }
        return count;
    }
}
