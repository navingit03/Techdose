//Leetcode 79. Word Search

class Solution {
    public boolean visted[][]; //to check if board[i][j] is already visited we should not visit it again during curr search
    public boolean search(char[][] board,String word,int i,int j,int index)
    {
        if(index==word.length()) //if word found
        {
            return true;
        }
        if(i>=board.length||i<0||j<0||j>=board[i].length||board[i][j]!=word.charAt(index)||visted[i][j]) //invalid conditions
        {
            return false;
        }
        visted[i][j]=true; //to denote curr board[i][j] is visited
        if(search(board,word,i+1,j,index+1)||search(board,word,i,j+1,index+1)||search(board,word,i-1,j,index+1)||search(board,word,i,j-1,index+1))
        {
            return true; //if answer found then return true
        }
        visted[i][j]=false; //backtracking 
        return false;
    }
    public boolean exist(char[][] board, String word)  //main method
    {
        visted=new boolean[board.length][board[0].length]; //creating visited boolean matrix
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(word.charAt(0)==board[i][j]) //if board[i][j] is equal to first letter of word we need to search in all the direction
                {
                    if(search(board,word,i,j,0)) //search method call
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
