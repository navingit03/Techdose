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
                // check below to see how it works
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
/*
Those who can't understand the logic for subgrid part of sudoku can think of like -
There are 3 sized rows and columns so we have to do row/3 and column/3 to get what specific subgrid we are in !!! But this will not be enough as we have to traverse whole subgrid also, so we have to add various coordinates like - 

offset is nothing but first element of subgrid 

offset(which we can get by row//3 and col//3)  
+ for each of given below 

(0,0) (0,1),(0,2),
(1,0) (1,1),(1,2),
(2,0) (2,1),(2,2)

offset + (0,0)
offset + (0,1)
offset + (0,2)

offset + (1,0)
offset + (1,1)
offset + (1,2)

offset + (2,0)
offset + (2,1)
offset + (2,2)

For example if we talk about what striver talks about at  19:24 (5,7) position
we can get subgrid offset by 
row offset = 5//3 ==>1
col offset = 7//3 ==> 2

 which is second rowth and third column subgrid -

|    0,0   |  0,1   |  0,2    |
|    1,0   |   1,1  |   1,2   |
|    2,0   |   2,1  |   2,2   |

The above is all 9 subgrid of sudoku

Again back with example we get 1,2 grid and now we have to add all coordinates to traverse that block
like 

(0,0) (0,1),(0,2),
(1,0) (1,1),(1,2),
(2,0) (2,1),(2,2)

for x= 0,0,0,1,1,1,2,2,2 ( extracting all x of above )
for y = 0,1,2,0,1,2,0,1,2 (extracting all y of above )

so basically x = i//3 
and y = i%3  for i ranging from 0 to 9

so finally formula is

for i=0 to 9
row = 3 * (x//3) + i//3  ==>  (offset + 0,0,0,1,1,1,2,2,2 )
col = 3*(y//3) + i % 3 ==> (offset + 0,1,2,0,1,2,0,1,2 )
*/
