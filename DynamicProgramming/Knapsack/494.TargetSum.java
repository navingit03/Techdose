//leetcode 494. Target Sum - 01 Knapsack
class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum+target<0||sum<target||(sum-target)%2==1) return 0; //if sum < target or its odd
        /*
         * s1-s2=target (-s2 as they belong to -ve partition)
         * s1-(sum-s1)=target  (as -> s2=sum-s1)
         * 2*s1=target+sum
         * s1=target+sum/2;
         * (new goal) now problem is converted to find no of subset with sum = s1
         */
        int diff=(target+sum)/2;
        int dp[][]=new int[arr.length+1][diff+1]; //1 indexed dp
        dp[0][0]=1;
        for(int i=1;i<=arr.length;i++) //index for all elements in arr
        {
            for(int j=0;j<=diff;j++) //increasing capacity from 0 till target for curr i th element
            {
                if(j<arr[i-1]) //curr element is greater than target
                {
                    dp[i][j]=dp[i-1][j]; //skip case
                }
                else
                {
                    int exclude=dp[i-1][j];
                    int include=dp[i-1][j-arr[i-1]];
                    dp[i][j]=exclude+include; //adding left sub problem and right sub problem
                }
            }
        }
        return dp[arr.length][diff];
    }
}
