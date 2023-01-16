class Solution {
    //LCS
    public int findLength(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int dp[][]=new int[len1+1][len2+1];
        int max=0;
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0||j==0) //if any one of then subarray is empty return 0;
                {
                    dp[i][j]=0;
                }
                else if(nums1[i-1]==nums2[j-1]) //same numbers
                {
                    dp[i][j]=1+dp[i-1][j-1]; 
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
