import java.util.*;
public class Subsets {
    static List<String> list=new ArrayList<>();
    static void subset(String str,int index,String curr)
    {
        if(index==str.length())
        {
            list.add(curr); //adding a subset to result
            return;
        }
        subset(str, index+1,curr); //recursive call
        curr=curr+str.charAt(index); //adding character
        subset(str, index+1,curr); //backtracking
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next(); //input string
        subset(str,0,""); //function call
        System.out.println(list); //printing result
        sc.close();
        /*
        hsah
        [, h, a, ah, s, sh, sa, sah, h, hh, ha, hah, hs, hsh, hsa, hsah]
        */
    }
}
