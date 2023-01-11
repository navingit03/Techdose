class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int connect[][]=new int[n+1][n+1]; //n+1 size as there is no vertex-0
        int indegree[]=new int[n+1];
        for(int i=0;i<edges.length;i++){
            int v1=edges[i][0];
            int v2=edges[i][1];
            connect[v1][v2]=1; //making connection
            connect[v2][v1]=1; //bidirected graph
            indegree[v1]++; //increasing degree
            indegree[v2]++;
        }
        int res=Integer.MAX_VALUE;
        //all possible trio
        for(int i=1;i<=n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                for(int k=j+1;k<=n;k++)
                {
                    if(connect[i][j]==1 && connect[j][k]==1 && connect[k][i]==1) //checking if there is a trio
                    {
                        res=Math.min(res,indegree[i]+indegree[j]+indegree[k]-6); //-6 as each v has 2 indegree (2*3)=6
                    }
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
