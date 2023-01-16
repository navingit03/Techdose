//can we convert s1 to s2 in one operation(insert,delete,replace)
package editdistance;

public class OneEditDiatance {
    public static void main(String[] args) {
        String word1="abc";
        String word2="abd";
        int len1=word1.length();
        int len2=word2.length();
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
        {
            for(int j=0;j<=len2;j++)
            {
                if(i==0) //if s1 is empty we need to insert s2(j characters)
                {
                    dp[i][j]=j;
                }
                else if(j==0) //if s2 is empty we need to insert s1(i characters)
                {
                    dp[i][j]=i;
                }
                else if(word1.charAt(i-1)==word2.charAt(j-1)) //both are same no need to modify
                {
                    dp[i][j]=dp[i-1][j-1]; //skip case
                }
                else
                {
                    int insert=1+(dp[i][j-1]); //i point to already present char in s1 and j-1 as newly added and j is same
                    int delete=1+(dp[i-1][j]); //if i is deleted then i-1
                    int replace=1+dp[i-1][j-1]; //if we replace then both became same i-- j--
                    dp[i][j]=Math.min(insert,Math.min(delete,replace)); //choosing to make min operatoins
                }
            }
        }
        System.out.println("One Operation To Make S1 to S2 "+((dp[len1][len2]==1)?"TRUE":"FALSE"));
    }
}
