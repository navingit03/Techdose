//Leetcode 51. N-Queens
class Solution {
    List<List<String>> list=new ArrayList<>();
    public void solve(int col,char[][] mat,int n,int[] leftrow,int []upperDiagonal,int []lowerDiagonal){
        if(col==n) //if 'Q' is added from 0 to n-1 (i.e: all 'Q' are placed in valid position so they don't attack each other)
        {
            List<String> str=new ArrayList<>();
            for(char[] row:mat){
                str.add(new String(row));
            }
            list.add(str); //str is string representation of mat
            return;
        }
        for(int row=0;row<n;row++) //filling 'Q' row-wise from 0-n-1
        {
            if(leftrow[row]==0 && lowerDiagonal[row+col]==0&&upperDiagonal[(n-1)+(col-row)]==0)
            //if leftrow[currrow]==0 which means no 'Q' on left side of same row
            //if lowerDiagonal[row+col]==0 which means no 'Q' on left side of same lowerDiagonal as all lowerDiagonal of line will be row+col
            //if upperDiagonal[n-1+col-row]==0 which means no 'Q' on left side of same upperDiagonal as all upperDiagonal of line will be n-1+col-row
            {
                mat[row][col]='Q';
                leftrow[row]=1; //freq of curr row=1 so that in further cols 'Q' will not be placed in same row
                lowerDiagonal[row+col]=1; //freq of curr lowerDiagonal=1 so that in further lowerDiagonal 'Q' will not be placed in same lowerDiagonal
                upperDiagonal[(n-1)-(row-col)]=1; //freq of curr upperDiagonal=1 so that in further upperDiagonal 'Q' will not be placed in same upperDiagonal
                solve(col+1,mat,n,leftrow,upperDiagonal,lowerDiagonal); //recursion call for col+1
                mat[row][col]='.'; //removing lastly add 'Q' (backtracking)
                //reducing freq to 0 because of removing 'Q'
                leftrow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[(n-1)+(col-row)]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char mat[][]=new char[n][n]; //character matrix to represent chess board
        for(char []arr:mat)
        {
            Arrays.fill(arr,'.'); //filling all with '.'
        }
        //we only check left row,left upperDiagonal,left lowerDiagonal as 'Q' is added from 0 to n of col(left to right)
        int leftrow[]=new int[n]; //row frequency to check if already 'Q' is present in same row on left side
        int upperDiagonal[]=new int[2*n-1]; //upperDiagonal frequency to check if already 'Q' is present in same upperDiagonal on left side
        int lowerDiagonal[]=new int[2*n-1]; //lowerDiagonal frequency to check if already 'Q' is present in same lowerDiagonal on left side
        
        solve(0,mat,n,leftrow,upperDiagonal,lowerDiagonal); //method call
        return list;
    }
