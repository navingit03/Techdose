/* Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's. (in-place - modify the given matrix)
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row=new HashSet<>();
        Set<Integer> col=new HashSet<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    row.add(i); //add i th row in row_set
                    col.add(j); //add j th col in col_set;
                }
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(row.contains(i) || col.contains(j))
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
}
