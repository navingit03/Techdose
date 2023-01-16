class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0)
                {
                    dp[i][j]=1; //as they can be reached by either rigth(0th-row) or down(0th -col)
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1]; //as curr (i,j) can be reached from i-1 or j-1
                }
            }
        }
        return dp[m-1][n-1];
    }
}
