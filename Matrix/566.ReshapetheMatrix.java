class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        if((m==r) && (n==c)) //if same size return mat
        {
            return mat;
        }
        if((m*n)!=(r*c)) //if total element differs return mat
        {
            return mat;
        }
        int cr=0,cc=0;
        int res[][]=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                res[i][j]=mat[cr][cc++];
                if(cc==n) //if currcol is reached end of col
                {
                    cc=0; //cc start from 0
                    cr++; //increasing cuurrow
                }
            }
        }
        return res;
    }
}
