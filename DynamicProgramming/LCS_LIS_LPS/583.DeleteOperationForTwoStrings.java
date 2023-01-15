//583. Delete Operation for Two Strings 
//delete characters to make string same - find lcs and res=len1+len2-(2*noOfLcsCharacters)
class Solution {
    public int minDistance(String word1, String word2) {
        //find len1+len2-(2*noOfLcsCharacters) to be deleted
        int len1=word1.length();
        int len2=word2.length();
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0||j==0){
                    dp[i][j]=0; //if one is empty then make it 0
                }
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lcslength=dp[len1][len2]; 
        int totallcscharacters=2*lcslength; //total common char in both strings
        return len1+len2-totallcscharacters; //to delete total - 2*lcs
    }
}
