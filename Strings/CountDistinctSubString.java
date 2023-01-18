import java.util.HashSet;

import java.util.*;
class CountDistinctSubString
{
    public static void main(String[] args) {
        String s="abc";
        Set<String> set=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<=s.length();j++)
            {
                if(!set.contains(s.substring(i,j))){
                    set.add(s.substring(i,j));
                    //System.out.println(s.substring(i, j));
                }
            }
        }
        System.out.print(set.size()+1);
    }
}
