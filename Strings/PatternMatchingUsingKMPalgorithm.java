import java.util.*;
public class PatternMatchingUsingKMP {
    public static List<Integer> patternFind(String text,String pattern, int[]LPS)
    {
        int n=text.length();
        int m=pattern.length();
        List<Integer> list=new ArrayList<>();
        int i=0; //index in text
        int j=0; //index in pattern
        while(i<n)
        {
            if(text.charAt(i)==pattern.charAt(j)) //if both char are same
            {
                i++;
                j++;
            }
            if(j==m) //if pattern index j reached end
            {
                int startIndexOfPattern=i-m;
                list.add(startIndexOfPattern);
                j=LPS[j-1]; //moving j to LPS[j-1]
            }
            else if(i<n && text.charAt(i)!=pattern.charAt(j)) //if both char are not equal
            {
                if(j==0) //if pattern index=0 then move only text index i++
                {
                    i++; //move text index++
                }
                else
                {
                    j=LPS[j-1]; //moving j
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String text="ABCDABCDAB";
        String pattern="ABCD";
        int LPS[]=new int[pattern.length()];
        LPS[0]=0;
        int i=0; //start point of prefix
        int j=1; //end point of suffix
        while(j<pattern.length())
        {
            if(pattern.charAt(i)==pattern.charAt(j))
            {
                LPS[j]=i+1; //from 0 to i (i+1) characters are prefix and j-i to j (i+1) character suffix
                i++;
                j++;
            }
            else if(i!=0) //if i > 0 and i th character and j th character does not match
            {
                i=LPS[i-1]; //moving i towards left(LPS[i-1])
            }
            else //if i==0 and i th character and j th character does not match
            {
                LPS[j]=0;
                j++;
            }
        }
        List<Integer> list=patternFind(text,pattern,LPS);
        System.out.print("The starting index of pattern in text are"+list);
    }
}
