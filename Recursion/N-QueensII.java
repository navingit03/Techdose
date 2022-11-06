//Leetcode 52. N-Queens II
//same as 51. N-Queens.java, but here we need to find no of possible ways(count) of 'Q' arrangement. There we need to find possible output as string
//(see 51. N-Queens.java on take u forward yt)
class Solution {
    int ans=0;
    public void solve(int col,int n,int[] leftrow,int[] lowerDiagonal,int[] upperDiagonal){
        if(col==n){
            ans++;
        }
        for(int row=0;row<n;row++){
            if(leftrow[row]==0&&lowerDiagonal[row+col]==0&&upperDiagonal[n-1+col-row]==0){
                leftrow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;
                solve(col+1,n,leftrow,lowerDiagonal,upperDiagonal);
                leftrow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;
            }
        }
    }
    public int totalNQueens(int n) {
        int leftrow[]=new int[n];
        int lowerDiagonal[]=new int[2*n-1];
        int upperDiagonal[]=new int[2*n-1];
        solve(0,n,leftrow,lowerDiagonal,upperDiagonal);
        return ans;
    }
}
