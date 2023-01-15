package substring;

public class LongestCommonSubstring {
    public static int lcsrecursion(String s1,int i,String s2,int j,int len){
        if(i==s1.length()||j==s2.length()){
            return len;
        }
        int count=0;
        if(s1.charAt(i)==s2.charAt(j)){
            count=lcsrecursion(s1, i+1, s2, j+1, len+1); //increasing len(lcs)
        }
        
        return count=Math.max(count,Math.max(lcsrecursion(s1, i+1, s2, j, 0),lcsrecursion(s1, i, s2, j+1, 0)));

    }
    public static int lcsDP(String s1,String s2){
        int len1=s1.length();
        int len2=s2.length();
        int lcslen=0;
        int endIndex=0;
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0||j==0) //if s1 or s2 is empty
                {
                    dp[i][j]=0;
                }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    if(lcslen<dp[i][j]){
                        lcslen=dp[i][j];
                        endIndex=i;
                    }
                }else
                {
                    dp[i][j]=0;
                }
            }
        }
        System.out.println(s1.substring(endIndex-lcslen, endIndex)); //printing end-lcslen(st) till end
        return lcslen;
    }
    public static void main(String[] args) {
        String s1="abcdxyz";
        String s2="xyzabcd";
        System.out.println("Recursion "+lcsrecursion(s1,0,s2,0,0)); //4
        System.out.println("DP + tabulation "+lcsDP(s1,s2));
    }
}
