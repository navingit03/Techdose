import java.util.*;

public class PermutationOfString {
    public static List<String> list=new ArrayList<>();
    public static String swap(String s,int i,int j)
    {
        char []arr=s.toCharArray();
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return String.valueOf(arr);
    }
    public static void permut(String s,int left,int right)
    {
        if(left==right)
        {
            list.add(s);
            return;
        }
        for(int i=left;i<=right;i++)
        {
            s=swap(s,i,left); //swapping i with left
            permut(s, left+1, right); //next index
            s=swap(s,i,left); //backtracking
        }
    }
    public static void main(String[] args) {
        String s="ABC"; //no of premutation=n! ways
        permut(s,0,s.length()-1);
        System.out.print(list.toString());
    }
}
