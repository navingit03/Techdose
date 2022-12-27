class Solution {
    public void dfsMakeZero(char [][]grid,int i,int j){
        int r=grid.length; //no of row
        int c=grid[0].length; //no of col
        if(i<0||j<0||i>=r||j>=c) //invalid index
        {
            return;
        }
        if(grid[i][j]=='0') //if water return
        {
            return;
        }
        grid[i][j]='0'; //making land into water
        dfsMakeZero(grid,i,j-1); //making left land into water
        dfsMakeZero(grid,i,j+1); //making right neighbour land into water
        dfsMakeZero(grid,i+1,j); //making top neighbour land into water
        dfsMakeZero(grid,i-1,j); //making down neighbour land into water
    }
    public int numIslands(char[][] grid) {
        int r=grid.length; //no of row
        int c=grid[0].length; //no of col
        int count=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='1') //if current is land
                {
                    count++;
                    dfsMakeZero(grid,i,j); //making all its neighbour land into water
                }
            }
        }
        return count;
    }
}
