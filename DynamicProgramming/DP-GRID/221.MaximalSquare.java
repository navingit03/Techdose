class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m+1][n+1];
        int max=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // 0 th row and 0 th col and matrix[i][j]=='0' dp[i][j]=0(default)
                if(matrix[i-1][j-1]=='1') //if curr char is 1
                {
                    int top=dp[i-1][j];
                    int left=dp[i][j-1];
                    int dia=dp[i-1][j-1];
                    dp[i][j]=1+Math.min(dia,Math.min(top,left)); //finding min on three sides
                    max=Math.max(max,dp[i][j]); //updating max
                    
                }
            }
        }
        return max*max; //area
    }
}
