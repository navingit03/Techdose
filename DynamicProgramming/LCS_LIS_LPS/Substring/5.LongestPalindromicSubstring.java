class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        int max=1;
        int mat[][]=new int[len][len]; //for(i to j) we have to check is it is palindrom
        int st=0,end=0;
        //fill diagnoal by 1,base condtion -for 1 length substring, as subst(0,0),subst(1,1) will always be palindrom
        for(int i=0;i<len;i++){
            mat[i][i]=1;
        }
        //filling one more base condition for 2 length substring 
        for(int i=1;i<len;i++){
            if(s.charAt(i-1)==s.charAt(i)){
                mat[i-1][i]=1;
                st=i-1;
                end=i;
            }
        }
        for(int j=2;j<len;j++) //end index
        {
            for(int i=0;i<len-1;i++) //start index
            {
                if(mat[i+1][j-1]==1&&(s.charAt(i)==s.charAt(j))) //if i and j th char are same and from i+1 to j-1 is a palindrom.
                {
                    mat[i][j]=1;
                    if((j-i)>max)
                    {
                        st=i;
                        end=j;
                    }
                    max=Math.max(max,j-i);
                }
            }
        }
        return s.substring(st,end+1);
    }
}
