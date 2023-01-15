//we are given p and s string , we need to find if p is subsequence of s
//if lcs of p and s == p return true else false
public class PatternMatchingIfPisSubsequenceOfS {
    public static boolean isSubsequence(String p,String s){
        int len1=p.length();
        int len2=s.length();
        String dp[][]=new String[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0||j==0) //if p is empty or s is empty
                {
                    dp[i][j]="";
                }
                else if(p.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+p.charAt(i-1); //if curr char is same add the char and move diagonal
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
        return dp[len1][len2].equals(p); //if lcs and p are matching
    }
    public static void main(String[] args) {
        System.out.println(isSubsequence("AAB","ABBABB")); //true as AAB is subsequence of ABBABB
        System.out.println(isSubsequence("AAB","ABBBA")); //false as AAB is not subsequence of ABBBA
    }
    
}
