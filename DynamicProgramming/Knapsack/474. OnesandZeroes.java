//leetcode 474. Ones and Zeroes by dp-tabulation
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int index=0;index<strs.length;index++){
            int zeros=0;
            int ones=0;
            for(int i=0;i<strs[index].length();i++){
                if(strs[index].charAt(i)=='0') zeros++; //counting no of zeros
                else ones++; //counting no of ones
            }
            for(int zero=m;zero>=zeros;zero--) //as no of zero range from 0 - m-zeros
            {
                for(int one=n;one>=ones;one--) //as no of one range from 0 - n-ones
                {
                    dp[zero][one]=Math.max(1+dp[zero-zeros][one-ones],dp[zero][one]); //include or exclude
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode 474. Ones and Zeroes by recursion+memoization
class Solution {
class Solution {
    int [][][]dp;
    public int findMax(String[] strs,int m,int n,int index){
        if(index==strs.length) //if end is reached return 0
        {
            return 0;
        }
        if(dp[m][n][index]!=0)
        {
            return dp[m][n][index]; //already found  (memoization)
        }
        int zeros=0;
        for(int i=0;i<strs[index].length();i++)
        {
            if(strs[index].charAt(i)=='0')
            {
                zeros++; //counting no of zeros in strs[index]
            }
        }
        int ones=strs[index].length()-zeros; //calculating no of ones in strs[index]
        if(m-zeros<0||n-ones<0) //skip case(capacity is less than zeros or ones)
        {
            return dp[m][n][index]=findMax(strs,m,n,index+1); //exclude case
        }
        return dp[m][n][index]=Math.max(1+findMax(strs,m-zeros,n-ones,index+1),findMax(strs,m,n,index+1)); //max(1+include or exclude)
    }
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new int[m+1][n+1][strs.length]; //memoization
        return findMax(strs,m,n,0);
    }
}
