//leetcode 516. Longest Palindromic Subsequence 
//to find lps we need to rev string s and need to find lcs of s and rev
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0||j==0) //if anyone is empty then return 0
                {
                    dp[i][j]=0;
                }
                else if(text1.charAt(i-1)==text2.charAt(j-1)) //if i and j th char are same add 1 to dp[i-1][j-1](subproblem)
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]); //max of dp[i-1][j],dp[i][j-1]
                }
            }
        }
        return dp[len1][len2];
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        String rev=sb.reverse().toString();
        //now we need to find lcs of s and rev (to find longest common subsequence)
        return longestCommonSubsequence(s,rev);
    }
}
