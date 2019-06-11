package medium;

public class LeetCode79_Word_Search {
	//6
	int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	
	//5
    boolean visited[][];
    int m,n;
    //7
    private boolean isArea(int x,int y){
        if(x < m && x >= 0 && y < n && y >= 0)
            return true;
        return false;
    }
    //2
    private boolean searchWord(char[][] board,String word,int index,int x,int y){
    	//3
        if(index == word.length() - 1)
            return word.charAt(index) == board[x][y];
        //4
        if(board[x][y] == word.charAt(index)){
            visited[x][y] = true;
            for(int i = 0; i < 4; i ++){
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                //9
                if( isArea(newX,newY) && !visited[newX][newY] &&
                    searchWord(board,word,index + 1,newX,newY))
                    return true;
            }
            //10
            visited[x][y] = false;
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
    	//8
        m = board.length;
        if(m == 0)return false;
        n = board[0].length;
        visited = new boolean[m][n];
        //1
        for(int i = 0; i < board.length; i ++)
            for(int j = 0; j < board[0].length; j ++)
                if(searchWord(board,word,0,i,j))
                    return true;
        return false;
                
    }
    
}
