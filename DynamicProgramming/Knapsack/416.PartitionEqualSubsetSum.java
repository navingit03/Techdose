// 0/1 - knapsack approach (include and exclude)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if((sum&1)==1) return false; //if sum is odd then we cannot divide into two subsets
        int target=sum/2; //if one subset''sum == target then there will be another subset sum == target
        boolean dp[][]=new boolean[n+1][target+1];
        for(int i=0;i<=nums.length;i++) //index for all elements in arr
        {
            for(int j=0;j<=target;j++) //increasing capacity from 0 till target for curr i th element
            {
                if(j==0) //target is 0 then we will not include any item - true
                {
                    dp[i][j]=true;
                }
                else if(i==0) //as there is no item to sum upto target
                {
                    dp[i][j]=false;
                }
                else if(j<nums[i-1]) //curr element is greater than target
                {
                    dp[i][j]=dp[i-1][j]; //skip case
                }
                else
                {
                    boolean exclude=dp[i-1][j];
                    boolean include=dp[i-1][j-nums[i-1]];
                    dp[i][j]=exclude||include;
                }
            }
        }
        return dp[n][target]; 
    }
}
