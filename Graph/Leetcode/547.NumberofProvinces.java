//547. Number of Provinces (finding no of components in graph)
//SC:O(n) + O(n) -> visited array and recursion stack
//TC:O(n)+ O(v+2e) -> for loop + dfs of all components
class Solution {
    public void dfs(int [][]isConnected,int visited[],int curr)
    {
        for(int i=0;i<isConnected[curr].length;i++) //all curr adjNode
        {
            if(i!=curr&&visited[i]==0&&isConnected[curr][i]==1) //no self path && not visitied [i] && connection curr->i is true
            {
                visited[i]=1; //making it visited
                dfs(isConnected,visited,i); //dfs call
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        //to find no of components in given graph
        int visited[]=new int[isConnected.length]; //visited array
        int cnt=0; //total no of components (initially 0)
        for(int i=0;i<isConnected.length;i++) //taking first node as 0 and to n-1 nodes(total n nodes)
        {
            if(visited[i]==0) //if curr node is not visited then visiting all its components using dfs/bfs
             {
                visited[i]=1; //making i th node as visited
                cnt++; //increasing cnt of components
                dfs(isConnected,visited,i); //dfs call
            }
        }
        return cnt; //returning no of components
    }
}
