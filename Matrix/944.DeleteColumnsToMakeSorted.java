/*
For example, strs = ["abc", "bce", "cae"] can be arranged as follows:
abc
bce
cae
---
TFT -- true false true
You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted, while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
*/
class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0; // to find no of deleted column
        int row=strs.length;
        int col=strs[0].length();
        for(int i=0;i<col;i++) //checking every column
        {
            boolean t=true;
            for(int j=0;j<row-1;j++) //all word from 0 to r-1
            {
                if(strs[j].charAt(i)>strs[j+1].charAt(i)) //if col(i) char of word next is small 
                {
                    t=false; //make it false;
                }
            }
            if(t==false) //if false we can delete that
            {
                count++; //increase count
            }
        }
        return count;
    }
}
