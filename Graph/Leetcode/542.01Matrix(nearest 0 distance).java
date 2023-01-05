//542. 01 Matrix leetcode by bfs
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r=mat.length,c=mat[0].length;
        int ans[][]=new int[mat.length][mat[0].length]; //return ans matrix
        int visited[][]=new int[mat.length][mat[0].length]; //visited matrix
        Queue<int[]> q=new LinkedList<>(); //queue to store zero's index
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0) //if already zero
                {
                    visited[i][j]=1; //make it visited
                    ans[i][j]=0; //ans[i][j]=0 as it already nearest zero
                    q.offer(new int[]{i,j}); //add index in queue
                }else{
                    ans[i][j]=Integer.MAX_VALUE; //else its curr near zero at int max distance
                }
            }
        }
        int dir[][]={{-1,0},{0,-1},{1,0},{0,1}}; //four direction traversal
        while(!q.isEmpty())
        {
            int curr[]=q.poll(); //curr index which has 0 in it
            for(int i=0;i<4;i++)
            {
                int newrow=curr[0]+dir[i][0]; //newrow and newcol in 4 direction
                int newcol=curr[1]+dir[i][1];
                if(newrow>=0&&newrow<r&&newcol>=0&&newcol<c&&visited[newrow][newcol]==0) //if new index is valid and not visited
                {
                    if(ans[newrow][newcol]>ans[curr[0]][curr[1]]+1) //if new index dis > dis of curr+1
                    {
                        ans[newrow][newcol]=ans[curr[0]][curr[1]]+1; //sub value of dis of curr+1
                        visited[newrow][newcol]=1; //make it visited
                        q.offer(new int[]{newrow,newcol}); //add it in queue
                    }
                }
            }
        }
        return ans;
    }
}
