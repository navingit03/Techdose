//130. Surrounded Regions leetcode by dfs
class Solution {
    public void dfs(char[][] board,int [][]visited,int i,int j){
        int r=board.length,c=board[0].length;
        if(i<0||j<0||i>=r||j>=c||board[i][j]=='X'||visited[i][j]==1) //invalid index || already 'X' || already visited
        {
            return; //return
        }
        visited[i][j]=1; //make it visited
        //dfs call on four sides
        dfs(board,visited,i-1,j);
        dfs(board,visited,i+1,j);
        dfs(board,visited,i,j-1);
        dfs(board,visited,i,j+1);
    }
    public void solve(char[][] board) {
        int r=board.length,c=board[0].length;
        int visited[][]=new int[r][c];
        //searching boundry O's and its dfs O's as visited so that they not became X
        for(int i=0;i<r;i++) //boundy row condition
        {
            if(board[i][0]=='O'&&visited[i][0]==0)
            {
                dfs(board,visited,i,0);
            }
            if(board[i][c-1]=='O'&&visited[i][c-1]==0)
            {
                dfs(board,visited,i,c-1);
            }
        }
        for(int i=0;i<c;i++) //boundry col condition
        {
            if(board[0][i]=='O'&&visited[0][i]==0){
                dfs(board,visited,0,i);
            }
            if(board[r-1][i]=='O'&&visited[r-1][i]==0){
                dfs(board,visited,r-1,i);
            }
        }
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(visited[i][j]==0&&board[i][j]=='O') //if curr is 'O' and not visited by boundry dfs call then make it 'X'
                {
                    board[i][j]='X';
                }
            }
        }

    }
}
