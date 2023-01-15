//using dp and finding the LCS
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1="ABCDGH";
        String text2="AEDFHR";
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
        //to find the lcs string
        String ans=""; //ADH
        int i=len1,j=len2;
        while(i>0&&j>0) //repeat till valid index
        {
            if(text1.charAt(i-1)==text2.charAt(j-1)) //if both character are equal add them in ans (i-1,j-1 as dp is 1  indexed)
            {
                ans=text1.charAt(i-1)+ans;
                i--; j--; //going to before diagonal
            }else //if not equal 
            {
                if(dp[i-1][j]>=dp[i][j-1]) //if dp[up]>=dp[left] go to up
                {
                    i--;
                }
                else //if dp[up]<dp[left] go left
                {
                    j--;
                }
            }
        }
        System.out.print(ans);
    }
}
