class Solution {
    public int countSubstrings(String s) {
        int len=s.length();
        boolean dp[][]=new boolean[len][len];
        int count=0;
        for(int i=0;i<len;i++)
        {
            dp[i][i]=true; //single char is palindrome
            count++;
        }
        for(int i=1;i<len;i++){
            if(s.charAt(i)==s.charAt(i-1)) //two char is palindrome if they are equal
            {
                dp[i-1][i]=true;
                count++;
            }
        }
        for(int i=2;i<len;i++) //end index
        {
            for(int j=0;j<len-1;j++) //st index
            {
                if(s.charAt(i)==s.charAt(j)) //if substring has st and end same char
                {
                    if(dp[j+1][i-1]==true) //if centre substring without st and end is palindrome
                    {
                        dp[j][i]=true;
                        count++;
                    }

                }
            }
        }
        return count;
    }
}
