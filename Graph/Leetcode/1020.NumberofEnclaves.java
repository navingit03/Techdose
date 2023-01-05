//1020. Number of Enclaves leetcode by dfs
class Solution {
    public void dfs(int[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0) return; //invalid index || curr=0 return
        grid[i][j]=0; //make it zero
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public int numEnclaves(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        //problem to make bound 1's and its dfs as 0
        for(int i=0;i<c;i++)
        {
            if(grid[0][i]==1)
            {
                dfs(grid,0,i);
            }
            if(grid[r-1][i]==1)
            {
                dfs(grid,r-1,i);
            }
        }
        for(int i=0;i<r;i++)
        {
            if(grid[i][0]==1)
            {
                dfs(grid,i,0);
            }
            if(grid[i][c-1]==1)
            {
                dfs(grid,i,c-1);
            }
        }
        int cnt=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1) //after all dfs boundry call the rem 1 will be counted
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
