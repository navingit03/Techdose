class Solution {
    public String findLCS(String str1,String str2){
        int len1=str1.length();
        int len2=str2.length();
        String dp[][]=new String[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0||j==0) //if anyone is empty then return ""
                {
                    dp[i][j]="";
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)) //if i and j th char are same add char to dp[i-1][j-1](subproblem)
                {
                    dp[i][j]=dp[i-1][j-1]+str1.charAt(i-1);
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
    public String shortestCommonSupersequence(String str1, String str2) {
        String ans="";
        String lcs=findLCS(str1,str2); //finding lcs character so that it can be added only once in ans
        int p1=0,p2=0; //pointer to point str1,str2
        char arr[]=lcs.toCharArray();
        for(char ch:arr) //traversing through all characters in lcs
        {
            while(str1.charAt(p1)!=ch) //while lcs character is not found add p1 th char in str1 and p1++ 
            {
                ans+=(str1.charAt(p1));
                p1++;
            }
            while(str2.charAt(p2)!=ch) //while lcs character is not found add p2 th char in the str2 and p2++
            {
                ans+=(str2.charAt(p2));
                p2++;
            }
            ans+=ch; // adding lcs characters only once
            p1++; //increasing both p1 and p2 as lcs is added
            p2++;
        }
        ans+=str1.substring(p1)+str2.substring(p2); //if some characters after occurance of lcs in both str1 and str2
        return ans;
    }
}
