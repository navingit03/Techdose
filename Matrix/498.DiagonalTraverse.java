class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int arr[]=new int[m*n]; //to store m*n elements
        int index=0; //to add elements at index in arr
        int row=0,col=0; //starting element
        boolean up=true; //starting with upward direction and changing direction after every diagonal
        while(row<m&&col<n) //index bound condition
        {
            if(up) //if direction is upwards
            {
                while(row>0&&col<n-1) //till first row and last before col as at (row==0 || col==n-1) we have to col++ or row++ any one only
                {
                    arr[index++]=mat[row][col];
                    row--; //row-- as upward direction
                    col++; //col++ as upward direction
                }
                arr[index++]=mat[row][col]; //adding element at row==0 || col==n-1
                if(col==n-1) //if last col is reached row++
                {
                    row++;
                }else //if row==0->col++
                {
                    col++;
                }
            }else{
                while(row<m-1&&col>0) //till last row and first before col as at (row==m-1 || col==0) we have to col++ or row++ any one only
                {
                    arr[index++]=mat[row][col];
                    row++; //row-- as downward direction
                    col--; //col++ as downward direction
                }
                arr[index++]=mat[row][col]; //adding corner elements
                if(row==m-1) //if last row is reached col++
                {
                    col++;
                }else //if first col is reached row++
                {
                    row++;
                }
            }
            up=!up; //changing direction
        }
        return arr;
    }
}
