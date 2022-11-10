//Leetcode 37. Sudoku Solver
class Solution {
    public boolean isValid(char[][] board,int row,int col,char ch){
        for(int i=0;i<9;i++){
            if(board[row][i]==ch) //checking if that row already has ch 
            {
                return false;
            }
            if(board[i][col]==ch) //checking if that col already has ch 
            {
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch) //checking if that 3*3 box already has ch 
            {
                return false;
            }
        }
        return true; //if ch is not found any row,col,box then return true 
    }
    public boolean solve(char[][] board){
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.') //if curr board[i][j]=='.' we have to try all combination 
                {
                    for(char ch='1';ch<='9';ch++) //if '1' to '9' can be placed at the board[i][j]
                    {
                        if(isValid(board,i,j,ch))
                        {
                            board[i][j]=ch; //putting board[i][j]=ch if valid
                        
                            if(solve(board)) //and again checking if board is valid after board[i][j]=ch by recursion call
                            {
                                return true;
                            }
                            else
                            {
                                board[i][j]='.'; //not valid then making it '.' , to try other combination
                            }
                        }
                    }
                    return false; //if all are checked and no combination is found return false
                }
            }
        }
        return true; //return true
    }
    public void solveSudoku(char[][] board) {
        solve(board); //method call
    }
}
