// leetcode 322. Coin Change 0/1 knapsack with repetation of each item
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(j==0) //target is 0 then we will not include any item - 0
                {
                    dp[i][j]=0;
                }
                else if(i==0) //no item to sum upto target
                {
                    dp[i][j]=100000; //infinite we can add zero
                }
                else if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
            }
        }
        return dp[n][amount]>1e4?-1:dp[n][amount];
    }
}
