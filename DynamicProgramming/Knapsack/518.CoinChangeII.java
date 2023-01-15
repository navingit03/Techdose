class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(j==0) //when target =0 we can exclude curr values
                {
                    dp[i][j]=1;
                }
                else if(i==0) //no of items i=0 so no possible combination
                {
                    dp[i][j]=0;
                }
                else if(j<coins[i-1]) //if curr coin value is greather than curr capacity j
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j] + dp[i][j-coins[i-1]]; //exclude go step up and include same row and curr capacity reduced by curr coin(i-1)
                }
            }
        }
        return dp[n][amount];
    }
}
