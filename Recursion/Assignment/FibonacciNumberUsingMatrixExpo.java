//Leetcode 509. Fibonacci Number
//we need to find mat[][]=base[][]^n-1 and mat[0][0] will be fib(n)
class Solution {
    int base[][]=new int[][]{{1,1},{1,0}};
    public int[][] matMul(int [][]a,int [][]b){
        int res[][]=new int[2][2]; //to store result of a*b
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                for(int k=0;k<2;k++)
                {
                    res[i][j]+=(a[i][k]*b[k][j]);
                }
            }
        }
        return res;
    }
    public int[][] matExpo(int [][]base,int power){
        if(power==1) return base; //if power==1 return base matrix
        int half=power/2; //if n=8 we need to find mat^4 and multiply (mat^4)*(mat^4)
        int mat[][]=matExpo(base,half); //recursion call for mat^(n/2)
        mat=matMul(mat,mat); //ans=(mat^n/2)*(mat^n/2)
        if((power%2)!=0)
        //if power is odd we need to multiply ans by baseMatrix
        //ex: if power=7 we need to find mat^3 * mat^3 * mat
        {
            mat=matMul(mat,base);
        }
        return mat; //returning ans
    }
    public int fib(int n) {
        if(n==0 || n==1) return n;
        int mat[][]=matExpo(base,n-1); //to find fib(n) we need to find fib[][] = (mat[][])^n-1
        return mat[0][0]; //mat[0][0] will be the fib(n) (where mat[][] will be (baseMatrix)^n-1)
    }
}
