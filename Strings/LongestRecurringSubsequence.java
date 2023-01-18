//LongestRepeatingSubsequence same question
//find longest repeating subsequence in which characters of two subsequences are same but not same index of s character
public class LongestRecurringSubsequence {
    public static void main(String[] args) {
        String s="AABB";
        int len=s.length();
        int dp[][]=new int[len+1][len+1];
        for(int i=0;i<=len;i++)
        {
            for(int j=0;j<=len;j++)
            {
                if(i==0||j==0) //if any one is empty string no common subsequence
                {
                    dp[i][j]=0;
                }
                else if(s.charAt(i-1)==s.charAt(j-1)&&(i!=j)) //i-1 and j-1 same char and diff index 1+(not include case)
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]); //max of not including i th char or j th char
                }
            }
        }
        System.out.print(dp[len][len]); //2
    }
}
