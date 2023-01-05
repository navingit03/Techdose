//dfs
class Solution {
    public boolean dfs(int [][]graph,int source,int visited[],int []color){
        if(visited[source]==1) return true;
        visited[source]=1;
        for(int i=0;i<graph[source].length;i++){
            int adj=graph[source][i];
            if(color[adj]==-1){
                color[adj]=(color[source]==0?1:0); //giving alternate color between node and adjnode
                if(dfs(graph,adj,visited,color)==false){
                    return false;
                }
            }else if(color[adj]==color[source]){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        //dfs method
        int visited[]=new int[graph.length]; //visited array
        int color[]=new int[graph.length]; //coloring array to color with 0's and 1's
        Arrays.fill(color,-1); //initially Filling with -1
        for(int k=0;k<graph.length;k++){
            if(visited[k]==0)
            {
                color[k]=0;
                if(dfs(graph,k,visited,color)==false) return false;
            }
        }
        return true;
    }
}

//bfs
class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[]=new int[graph.length];
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        for(int k=0;k<graph.length;k++){
            if(visited[k]==0){
                Queue<Integer> q=new LinkedList<>();
                q.offer(k);     
                color[k]=0;
                visited[k]=1;
                while(!q.isEmpty()){
                    int node=q.poll();
                    for(int i=0;i<graph[node].length;i++){
                        int adj=graph[node][i];
                        visited[adj]=1;
                        if(color[adj]==-1) //if adjNode is yet not coloured , give oppsite colour of the node
                        {
                            color[adj]=(color[node]==0?1:0);
                            q.offer(adj);
                        }else if(color[adj]==color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
