package GraphAlgo;
import java.util.*;
public class BipartiteByDFS {
    public static boolean dfs(int [][]graph,int source,int visited[],int []color){
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
    public static void main(String[] args) {
        int [][]graph={{1,2,3},{0,2},{0,1,3},{0,2}}; //not bipartite graph
        //int [][]graph={{1,3},{0,2},{1,3},{0,2}}; //bipartite graph
        int visited[]=new int[graph.length]; //visited array
        int color[]=new int[graph.length]; //coloring array to color with 0's and 1's
        Arrays.fill(color,-1); //initially Filling with -1
        for(int k=0;k<graph.length;k++){
            if(visited[k]==0)
            {
                color[k]=0;
                if(dfs(graph,k,visited,color)==false){
                    System.out.print("It's not a bipartite graph");
                    return;
                }
            }
        }
        System.out.print("It's a bipartite graph");
    }
}
