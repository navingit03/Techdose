//leetcode 1143. Longest Common Subsequence by recursion+memoization
class Solution {
    int memo[][];
    public int lcs(String text1,int index1,String text2,int index2){
        if(index1==text1.length()||index2==text2.length()){
            return 0;
        }
        if(memo[index1][index2]!=0) //if already found in memo
        {
            return memo[index1][index2];
        }
        if(text1.charAt(index1)==text2.charAt(index2)) //both character are same 
        {
            return memo[index1][index2]=1+lcs(text1,index1+1,text2,index2+1); //increase both index by 1
            //adding 1 to a subproblem(optimal substructure %%%)
        }
        return memo[index1][index2]=Math.max(lcs(text1,index1+1,text2,index2),lcs(text1,index1,text2,index2+1)); //max of increasing any one of the index
    }
    public int longestCommonSubsequence(String text1, String text2) {
        memo=new int[text1.length()][text2.length()];
        return lcs(text1,0,text2,0);
    }
}

////leetcode 1143. Longest Common Subsequence by dp+tabulation
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
}
