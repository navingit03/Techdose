class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) //if there is obstacle in st(0,0) return 0
        {
            return 0;
        }
        int dp[][]=new int[m][n]; //dp grid
        dp[0][0]=1; //st(0,0) is reached by 1 way
        for(int i=1;i<m;i++)
        {
            if(dp[i-1][0]==1&& obstacleGrid[i][0]==0) //if no obstacle and no previous obstacle
            {
                dp[i][0]=1; //1 possible way from top(i-1) to i
            }
            else
            {
                dp[i][0]=0; //else 0
            }
        }
        for(int j=1;j<n;j++){
            if(dp[0][j-1]==1 && obstacleGrid[0][j]==0) //if no obstacle and no previous obstacle
            {
                dp[0][j]=1; ////1 possible way from left(j-1) to j
            }else{
                dp[0][j]=0; //else 0
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) //if obstacle is found put 0
                {
                    dp[i][j]=0;
                }
                else
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1]; //top+left ways
                }
            }
        }
        return dp[m-1][n-1];
    }
}
