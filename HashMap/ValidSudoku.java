//Leetcode 36. Valid Sudoku
//we checking if sudoku is valid or not
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>(); //in Set we will be not able to add duplicate, so we will use this set for answer
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') //if board[i][j] is number
                {
                    if((!set.add("row"+i+board[i][j]))||(!set.add("col"+j+board[i][j]))) //!(add of num with its row or col) it is already present in row or col more than one time return false. if num is not present it will be added to set with row or col
                    {
                        return false;
                    }
                    if(!set.add("box"+i/3+board[i][j]+j/3)) //!(add of num with its 3*3 box) it is already present in box more than one time. if num is not present it will be added to set with box
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/
