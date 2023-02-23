/*
Input: s = "PAYPALISHIRING", numRows = 3

P   A   H   N
A P L S I I G
Y   I   R

Output: "PAHNAPLSIIGYIR"
*/
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int row=0,col=0;
        int curr=0;
        char[][] mat=new char[numRows][s.length()];
        for(char[] arr:mat){
            Arrays.fill(arr,' ');
        }
        while(curr<s.length()){
            while(row<numRows&&curr<s.length()) //traversing top to bottom
            {
                mat[row++][col]=s.charAt(curr++);
            }
            row=Math.max(0,row-2); //to move row and col for diagonal traversal (max (0,row-2) as row-2 can be negative)
            col++;
            while(row>0&&curr<s.length()) //diagonal traversal from left bottom to top right
            {
                mat[row--][col++]=s.charAt(curr++);
            }
        }
        String ans="";
        for(int i=0;i<numRows;i++){
            for(int j=0;j<s.length();j++){
                if(mat[i][j]!=' '){
                    ans=ans+mat[i][j];
                }
            }
        }
        return ans;
    }
}
