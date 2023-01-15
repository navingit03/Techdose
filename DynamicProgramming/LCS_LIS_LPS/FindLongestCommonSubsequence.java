//using dp and finding the LCS
public class LongestCommonSubsequence {
    public static String findlcs(String text1,String text2){
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
        String lcs=""; //ADH
        int i=len1,j=len2;
        while(i>0&&j>0) //repeat till valid index
        {
            if(text1.charAt(i-1)==text2.charAt(j-1)) //if both character are equal add them in ans (i-1,j-1 as dp is 1  indexed)
            {
                lcs=text1.charAt(i-1)+lcs;
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
        return lcs;
    }
    public static String findlcsStringDPtable(String text1,String text2){
        int len1=text1.length();
        int len2=text2.length();
        String dp[][]=new String[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0||j==0) //if anyone is empty then return ""
                {
                    dp[i][j]="";
                }
                else if(text1.charAt(i-1)==text2.charAt(j-1)) //if i and j th char are same add char to dp[i-1][j-1](subproblem)
                {
                    dp[i][j]=dp[i-1][j-1]+text1.charAt(i-1);
                }
                else
                {
                    if(dp[i-1][j].length()>=dp[i][j-1].length()){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i][j-1];
                    }
                }
            }
        }
        String lcs=dp[len1][len2];
        return lcs;
    }
    public static void main(String[] args) {
        String text1="ABCDGH";
        String text2="AEDFHR";
        System.out.println(findlcs(text1, text2)); //method 1 using dp table - ADH(ans)
        System.out.println(findlcsStringDPtable(text1,text2)); //method 2 finding lcs in String [][]dp table - ADH(ans)
    }
}
