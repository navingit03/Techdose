//leetcode 1035. Uncrossed Lines - dp+tabulation
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++) //taking first i elements on nums1
        {
            for(int j=0;j<=len2;j++) //taking first j elements on nums2
            {
                if(i==0||j==0) //if we take 0 element on nums1 or nums2 then we cannot make line
                {
                    dp[i][j]=0;
                }
                else if(nums1[i-1]==nums2[j-1]) //if currently included i and j th elements are same increase 1 to dp[i-1][j-1](before including both of them)
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]); //else find max of including any one of then item first
                }
            }
        }
        return dp[len1][len2];
    }
}
