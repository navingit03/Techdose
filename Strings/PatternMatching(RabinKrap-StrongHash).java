import java.util.ArrayList;
import java.util.List;
public class PatternMatchingUsingRabinKrapAlgo {
    public static List<Integer> search(String text,String Pattern)
    {
        List<Integer> list=new ArrayList<>(); //to store st index of pattern in text
        final int d=26; //total 26 character
        final int mod=(int)10e9+7; //to take mod
        int m=text.length(); //text length
        int n=Pattern.length(); //pattern length
        int patternSum=0; //to find patternSum
        //BAA (B-2,A-1) 2*26^2 + 1*26^1 + 1*26^0 %mod
        for(int i=n-1;i>=0;i--) //from right to left as ^x (x++ from right to left)
        {
            int value=Pattern.charAt(i)-'A'+1; //A-1 B-2 .....
            patternSum+=(value*(Math.pow(d,n-i-1)))%mod; //strong hashing
        }
        patternSum%=mod;
        int currSum=0;
        //AAB (A-1,B-2) 1*26^2 + 1*26^1 + 2*26^0 %mod
        for(int i=n-1;i>=0;i--)
        {
            int value=text.charAt(i)-'A'+1; //A-1 B-2 .....
            currSum+=(value*(Math.pow(d,n-i-1)))%mod; //strong hashing
        }
        currSum%=mod;
        for(int i=n;i<=m;i++)
        {
            if(patternSum==currSum) //if equal sum add st index of pattern
            {
                list.add(i-n);
            }
            if(i<m)
            {
                int stIndex=i-n; //to remove stIndex value
                int value=text.charAt(stIndex)-'A'+1;
                int minus= (int) ((value*Math.pow(d,n-1))%mod); //finding value to be removed
                currSum-=minus;
                currSum*=d; //as first char value is removed need to left shift sum by 26
                currSum+=text.charAt(i)-'A'+1; //adding newly added char value in window
            }
            
        }
        if(list.isEmpty())
        {
            list.add(-1);
        }
        return list;
    }
    public static void main(String[] args) {
        String text="AABAABAA";
        String pattern="BAA";
        System.out.print(search(text,pattern)); //2,5 is st index of pattern in text
    }
}
